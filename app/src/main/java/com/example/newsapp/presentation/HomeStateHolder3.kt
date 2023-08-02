package com.example.newsapp.presentation

import com.example.newsapp.domain.domain3.model.Article3

data class HomeStateHolder3(
    val isLoading: Boolean=false,
    val data:List<Article3>?=null,
    val error: String=""

)
