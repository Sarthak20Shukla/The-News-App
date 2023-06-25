package com.example.newsapp.domain.model

import com.example.newsapp.data.model.SourceDTO1

data class Article(
    val author: String,
    val content: String,
    val description: String,
   // val publishedAt: String,
   // val source: SourceDTO1,
    val title: String,
   // val url: String,
    val urlToImage: String
)

