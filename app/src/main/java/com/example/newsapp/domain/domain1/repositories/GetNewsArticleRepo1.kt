package com.example.newsapp.domain.domain1.repositories

import com.example.newsapp.domain.domain1.model.Article1

interface GetNewsArticleRepo1 {


    suspend fun getNewsArticle1(): List<Article1>

}