package com.example.newsapp.data.repositories

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.domain3.model.Article3
import com.example.newsapp.domain.domain3.repositories.GetNewsArticleRepo3
import com.example.newsapp.mappers.toDomain
import com.example.newsapp.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepo1Impl3 @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo3, SafeApiRequest() {
    override suspend fun getNewsArticle3(): List<Article3> {
       val response = safeApiRequest{apiService.getNewsArticles3()}
        return response.articles.toDomain()

    }
}