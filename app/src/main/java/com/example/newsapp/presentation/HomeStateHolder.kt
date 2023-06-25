package com.example.newsapp.presentation

import com.example.newsapp.domain.model.Article
import com.example.newsapp.utils.Resource

data class HomeStateHolder(
    val isLoading: Boolean=false,
    val data:List<Article>?=null,
    val error: String=""

)
