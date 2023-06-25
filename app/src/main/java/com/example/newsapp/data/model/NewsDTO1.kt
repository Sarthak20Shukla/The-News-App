package com.example.newsapp.data.model

data class NewsDTO1(
    val articles: List<ArticleDTO1>,
    val status: String?,
    val totalResults: Int?
)