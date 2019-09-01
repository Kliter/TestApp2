package com.kl.testapp2.main.domain

import com.kl.testapp2.flow.model.SearchResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GitHubServiceImpl : GitHubService {

    private val api: GitHubApi = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)

    override fun search(query: String): Call<SearchResult> {
        return api.search(query)
    }
}