package com.example.newsapp.domain.domain2.repositories

import com.example.newsapp.domain.domain2.model.Article2

interface GetNewsArticleRepo2 {


    suspend fun getNewsArticle2(): List<Article2>

}