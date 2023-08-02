package com.example.newsapp.mappers

import com.example.newsapp.data.model1.ArticleDTO4
import com.example.newsapp.domain.domain4.model.Article4

fun List<ArticleDTO4>.toDomain():List<Article4>{
    return  map{
        Article4(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            url=it.url?:"",
            urlToImage = it.urlToImage?:"",
            author = it.author?:""
        )
    }
}