package com.example.newsapp.mappers

import com.example.newsapp.data.model1.ArticleDTO2
import com.example.newsapp.domain.domain2.model.Article2

fun List<ArticleDTO2>.toDomain():List<Article2>{
    return  map{
        Article2(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            url=it.url?:"",
            urlToImage = it.urlToImage?:"",
            author = it.author?:""
        )
    }
}