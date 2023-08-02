package com.example.newsapp.mappers

import com.example.newsapp.data.model1.ArticleDTO3
import com.example.newsapp.domain.domain3.model.Article3

fun List<ArticleDTO3>.toDomain():List<Article3>{
    return  map{
        Article3(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            url=it.url?:"",
            urlToImage = it.urlToImage?:"",
            author = it.author?:""
        )
    }
}