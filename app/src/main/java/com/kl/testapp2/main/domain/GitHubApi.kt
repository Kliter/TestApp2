package com.kl.testapp2.main.domain

import com.kl.testapp2.flow.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories")
    fun search(@Query("q") query: String): Call<SearchResult>

}