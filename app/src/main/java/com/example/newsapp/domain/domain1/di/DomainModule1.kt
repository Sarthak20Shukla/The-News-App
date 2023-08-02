package com.example.newsapp.domain.domain1.di


import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repositories.GetNewsArticleRepo1Impl1
import com.example.newsapp.domain.domain1.repositories.GetNewsArticleRepo1
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule1 {

    @Provides
    fun providesGetNewsRepo(apiService: ApiService): GetNewsArticleRepo1 {
        return GetNewsArticleRepo1Impl1(apiService = apiService)
    }
}