package com.example.newsapp.domain.domain4.repositories

import com.example.newsapp.domain.domain4.model.Article4

interface GetNewsArticleRepo4 {


    suspend fun getNewsArticle4(): List<Article4>

}