package com.kl.testapp2.coroutine.flow.domain

import com.kl.testapp2.coroutine.flow.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    @GET("search/repositories")
    fun search(@Query("q") query: String): Call<SearchResult>

}