package com.example.newsapp.mappers

import com.example.newsapp.data.model1.ArticleDTO1
import com.example.newsapp.domain.domain1.model.Article1

fun List<ArticleDTO1>.toDomain():List<Article1>{
    return  map{
        Article1(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            url=it.url?:"",
            urlToImage = it.urlToImage?:"",
            author = it.author?:""
        )
    }
}