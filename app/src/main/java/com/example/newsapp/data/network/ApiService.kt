package com.example.newsapp.data.network

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.model.NewsDTO1
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNewsArticles(
   // @Query("q") q : String="",
    //@Query("category") category : String="top-headlines",
    @Query("country") country:String="in",
    @Query("ApiKey") apiKey:String=BuildConfig.API_KEY
    ):Response<NewsDTO1>
}