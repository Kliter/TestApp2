package com.kl.testapp2.flow.model

data class SearchResult(
    val total_count: Int,
    val incomplete_result: Boolean,
    val items: List<Repo>
)