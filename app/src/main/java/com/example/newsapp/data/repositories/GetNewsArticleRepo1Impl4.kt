package com.example.newsapp.data.repositories

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.domain4.model.Article4
import com.example.newsapp.domain.domain4.repositories.GetNewsArticleRepo4
import com.example.newsapp.mappers.toDomain
import com.example.newsapp.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepo1Impl4 @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo4, SafeApiRequest() {
    override suspend fun getNewsArticle4(): List<Article4> {
       val response = safeApiRequest{apiService.getNewsArticles4()}
        return response.articles.toDomain()

    }
}