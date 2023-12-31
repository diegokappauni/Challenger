package com.example.challenger.data.remote

import com.example.challenger.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<ArticlesResponse>
}