package com.example.newsapp.data.repositories

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.domain2.model.Article2
import com.example.newsapp.domain.domain2.repositories.GetNewsArticleRepo2
import com.example.newsapp.mappers.toDomain
import com.example.newsapp.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepo1Impl2 @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo2, SafeApiRequest() {
    override suspend fun getNewsArticle2(): List<Article2> {
       val response = safeApiRequest{apiService.getNewsArticles2()}
        return response.articles.toDomain()
    }
}