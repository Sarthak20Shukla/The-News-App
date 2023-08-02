package com.example.newsapp.domain.domain3.repositories

import com.example.newsapp.domain.domain3.model.Article3

interface GetNewsArticleRepo3 {


    suspend fun getNewsArticle3(): List<Article3>

}