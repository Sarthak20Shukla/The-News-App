package com.example.newsapp.presentation

import com.example.newsapp.domain.domain1.model.Article1

data class HomeStateHolder(
    val isLoading: Boolean=false,
    val data: List<Article1>? =null,
    val error: String=""

)
