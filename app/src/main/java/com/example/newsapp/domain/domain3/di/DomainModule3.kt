package com.example.newsapp.domain.domain3.di


import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repositories.GetNewsArticleRepo1Impl3
import com.example.newsapp.domain.domain3.repositories.GetNewsArticleRepo3
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule3 {

    @Provides
    fun providesGetNewsRepo3(apiService: ApiService): GetNewsArticleRepo3 {
        return GetNewsArticleRepo1Impl3(apiService = apiService)
    }
}