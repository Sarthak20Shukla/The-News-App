package com.example.newsapp.data.repositories

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.domain1.model.Article1
import com.example.newsapp.domain.domain1.repositories.GetNewsArticleRepo1
import com.example.newsapp.mappers.toDomain
import com.example.newsapp.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepo1Impl1 @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo1, SafeApiRequest() {
    override suspend fun getNewsArticle1(): List<Article1> {
       val response = safeApiRequest{apiService.getNewsArticles1()}
        return response.articles.toDomain()
    }
}