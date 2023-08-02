package com.example.newsapp.data.model1

data class NewsDTO3(
    val articles: List<ArticleDTO3>,
    val status: String?,
    val totalResults: Int?
)