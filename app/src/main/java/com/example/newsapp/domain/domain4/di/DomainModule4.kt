package com.example.newsapp.domain.domain4.di


import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repositories.GetNewsArticleRepo1Impl4
import com.example.newsapp.domain.domain4.repositories.GetNewsArticleRepo4
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule4 {

    @Provides
    fun providesGetNewsRepo4(apiService: ApiService): GetNewsArticleRepo4 {
        return GetNewsArticleRepo1Impl4(apiService = apiService)
    }
}