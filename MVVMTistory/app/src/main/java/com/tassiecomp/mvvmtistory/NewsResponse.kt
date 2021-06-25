package com.tassiecomp.mvvmtistory

import com.tassiecomp.mvvmtistory.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)