package com.example.newsapp.data.network

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.model1.NewsDTO1
import com.example.newsapp.data.model1.NewsDTO2
import com.example.newsapp.data.model1.NewsDTO3
import com.example.newsapp.data.model1.NewsDTO4
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNewsArticles1(
   // @Query("q") q : String="",
    //@Query("category") category : String="top-headlines",
    @Query("country") country:String="in",
    @Query("ApiKey") apiKey:String=BuildConfig.API_KEY
    ):Response<NewsDTO1>

    @GET("top-headlines")
    suspend fun getNewsArticles2(
        // @Query("q") q : String="",
        //@Query("category") category : String="top-headlines",
        @Query("country") country:String="us",
        @Query("ApiKey") apiKey:String=BuildConfig.API_KEY
    ):Response<NewsDTO2>

    @GET("top-headlines")
    suspend fun getNewsArticles3(
        // @Query("q") q : String="",
        @Query("category") category : String="business",
        @Query("country") country:String="in",
       // @Query("Country") country: String="us",
        @Query("ApiKey") apiKey:String=BuildConfig.API_KEY
    ):Response<NewsDTO3>

    @GET("top-headlines")
    suspend fun getNewsArticles4(
        // @Query("q") q : String="",
        @Query("category") category : String="sports",
        @Query("country") country:String="in",
        @Query("ApiKey") apiKey:String=BuildConfig.API_KEY
    ):Response<NewsDTO4>
}