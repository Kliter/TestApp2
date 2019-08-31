package com.kl.testapp2.coroutine.flow.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl.testapp2.coroutine.flow.domain.GitHubService
import com.kl.testapp2.coroutine.flow.ext.asFlow
import com.kl.testapp2.coroutine.flow.model.Repo
import com.kl.testapp2.coroutine.flow.model.SearchResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class FlowTestViewModel : ViewModel() {

    val org: MutableLiveData<String> = MutableLiveData()
    val repository: MutableLiveData<String> = MutableLiveData()

    val repos = object : MutableLiveData<List<Repo>>() {
        override fun onActive() {
            value ?: return

            viewModelScope.launch {
                var job: Deferred<Unit>? = null
                org.asFlow()
                    .combine(repository.asFlow()) { org, repo ->
                        Pair(org, repo) // 2つのEditTextの最新の値を合成する
                    }
                    .debounce(500)
                    .distinctUntilChanged()
                    .collect {
                        job?.cancel()
                        job = async(Dispatchers.Main) {
                            value = searchRepository(it.first, it.second)
                        }
                    }
            }
        }
    }

    private val service: GitHubService = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GitHubService::class.java)

    private suspend fun searchRepository(org: String?, repo: String?): List<Repo> =
        suspendCancellableCoroutine { continuation ->
            val query = listOfNotNull(
                if (org.isNullOrBlank()) null else "org:$org",
                if (repo.isNullOrBlank()) null else "in:name $repo"
            ).joinToString(" ")
            if (query.isBlank()) {
                continuation.resume(emptyList())
                return@suspendCancellableCoroutine
            }
            val call = service.search(query)
            call.enqueue(object : Callback<SearchResult> {
                override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                    if (continuation.isActive && !call.isCanceled) {
                        continuation.resumeWithException(t)
                    }
                }

                override fun onResponse(
                    call: Call<SearchResult>,
                    response: Response<SearchResult>
                ) {
                    continuation.resume(response.body()?.items ?: emptyList())
                }
            })
            continuation.invokeOnCancellation {
                call.cancel()
            }
        }
}
