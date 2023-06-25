package com.example.newsapp.mappers

import com.example.newsapp.data.model.ArticleDTO1
import com.example.newsapp.domain.model.Article

fun List<ArticleDTO1>.toDomain():List<Article>{
    return  map{
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:"",
            author = it.author?:""
        )
    }
}