package com.example.newsapp.data.model1

data class NewsDTO2(
    val articles: List<ArticleDTO2>,
    val status: String?,
    val totalResults: Int?
)