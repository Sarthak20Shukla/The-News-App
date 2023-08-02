package com.example.newsapp.domain.domain2.di


import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repositories.GetNewsArticleRepo1Impl2
import com.example.newsapp.domain.domain2.repositories.GetNewsArticleRepo2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule2 {

    @Provides
    fun providesGetNewsRepo2(apiService: ApiService): GetNewsArticleRepo2 {
        return GetNewsArticleRepo1Impl2(apiService = apiService)
    }
}