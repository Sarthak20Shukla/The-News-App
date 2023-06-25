package com.example.newsapp.domain.di

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repositories.GetNewsArticleRepoImpl
import com.example.newsapp.domain.repositories.GetNewsArticleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providesGetNewsRepo(apiService: ApiService): GetNewsArticleRepo{
        return GetNewsArticleRepoImpl(apiService = apiService)
    }
}