package com.example.newsapp.presentation

data class HomeStateHolder2(
    val isLoading: Boolean=false,
    val data: List<com.example.newsapp.domain.domain2.model.Article2>? =null,
    val error: String=""

)
