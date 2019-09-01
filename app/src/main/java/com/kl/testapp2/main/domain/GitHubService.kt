package com.kl.testapp2.main.domain

import com.kl.testapp2.flow.model.SearchResult
import retrofit2.Call

interface GitHubService {

    fun search(query: String): Call<SearchResult>

}