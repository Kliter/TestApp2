package com.kl.testapp2.flow.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl.testapp2.flow.ext.asFlow
import com.kl.testapp2.flow.model.Repo
import com.kl.testapp2.flow.model.SearchResult
import com.kl.testapp2.main.domain.GitHubService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class FlowTestViewModel(
    private val gitHubService: GitHubService
) : ViewModel() {

    val org: MutableLiveData<String> = MutableLiveData()
    val repository: MutableLiveData<String> = MutableLiveData()

    val repos = object : MutableLiveData<List<Repo>>() {
        /**
         * LiveData#onActive
         * LiveDataにactiveなObserverが付与された時に呼び出される。
         */
        override fun onActive() {
            value ?: return

            viewModelScope.launch {
                /**
                 * Deferred<T>
                 * Coroutineの結果を受け取るためのクラス。
                 */
                var job: Deferred<Unit>? = null
                try {
                    org.asFlow()// LiveDataをFlowにする。
                        /**
                         * Flow#combine
                         * 呼び出し元のFlowと引数に渡したFlowを繋げる。
                         * 繋げ方はラムダで定義している。
                         * この場合はorgのFlowとrepositoryのFlowをPairに詰める形で繋げている。
                         */
                        .combine(repository.asFlow()) { org, repo ->
                            /**
                             * Pair<A, B>
                             * 二つの組み合わせを表現するためののクラス。
                             * 色んな目的に使用される。
                             */
                            Pair(org, repo) // 2つのEditTextの最新の値を合成する
                        }
                        /**
                         * Delay#debounce
                         * 指定したタイムアウト内に出力された値を除外する。
                         *
                         * ex)
                         * flow {
                         *     emit(1)
                         *     delay(90)
                         *     emit(2)
                         *     delay(90)
                         *     emit(3)
                         *     delay(1010)
                         *     emit(4)
                         *     delay(1010)
                         *     emit(5)
                         * }.debounce(1000)
                         *
                         * 1000msecより後に出力されたものだけになるので、
                         * 出力: 3, 4, 5
                         */
                        .debounce(500)
                        /**
                         * Flow#distivtUtilChanged
                         * 繰り返しを削除するための関数。
                         */
                        .distinctUntilChanged()
                        /**
                         * Flow.collect
                         * consumeの終端関数。
                         *
                         */
                        .collect {
                            /**
                             * Job#cancel
                             * Jobを中断するための関数。
                             * エラーの原因や詳細を提供するために使用される。
                             * おそらくここでは前のJobを殺すために使用している。
                             */
                            job?.cancel()
                            job = async(Dispatchers.Main) {
                                value = searchRepository(
                                    it.first,
                                    it.second
                                ) //このvalueはどこから来ているの？→val reposか
                            }
                        }
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        }
    }

    private suspend fun searchRepository(org: String?, repo: String?): List<Repo> =
        /**
         * CancellableContinuation#searchRepository
         * コルーチンを一時中断する。
         * 中断中にコルーチンがキャンセルまたは完了した場合、CancellationExceptionを投げる。
         */
        suspendCancellableCoroutine { continuation ->
            val query = listOfNotNull(
                if (org.isNullOrBlank()) null else "org:$org",
                if (repo.isNullOrBlank()) null else "in:name $repo"
            ).joinToString(" ")

            if (query.isBlank()) {
                continuation.resume(emptyList())
                return@suspendCancellableCoroutine
            }
            val call = gitHubService.search(query)
            /**
             * Call#enqueue
             * 非同期リクエストの成功/失敗時のコールバックを定義する。
             */
            call.enqueue(object : Callback<SearchResult> {
                override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                    if (continuation.isActive && !call.isCanceled) {
                        /**
                         * Continuation#resumeWithException
                         * Exceptionが発生してもコルーチンの実行を継続する。
                         */
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

