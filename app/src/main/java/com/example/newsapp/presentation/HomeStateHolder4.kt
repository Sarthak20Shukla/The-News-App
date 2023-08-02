package com.example.newsapp.presentation

import com.example.newsapp.domain.domain4.model.Article4

data class HomeStateHolder4(
    val isLoading: Boolean=false,
    val data: List<Article4>? =null,
    val error: String=""

)
