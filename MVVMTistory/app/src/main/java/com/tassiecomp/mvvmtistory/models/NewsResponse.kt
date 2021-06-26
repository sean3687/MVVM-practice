package com.tassiecomp.mvvmtistory.models

import com.tassiecomp.mvvmtistory.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)