package com.example.newsapp.domain.repositories

import com.example.newsapp.domain.model.Article

interface GetNewsArticleRepo {


    suspend fun getNewsArticle():List<Article>
}