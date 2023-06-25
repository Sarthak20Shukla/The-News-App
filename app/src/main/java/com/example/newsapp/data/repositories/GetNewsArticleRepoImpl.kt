package com.example.newsapp.data.repositories

import com.example.newsapp.mappers.toDomain
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repositories.GetNewsArticleRepo
import com.example.newsapp.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo, SafeApiRequest() {
    override suspend fun getNewsArticle(): List<Article> {
       val response = safeApiRequest{apiService.getNewsArticles()}
        return response.articles.toDomain()
    }
}