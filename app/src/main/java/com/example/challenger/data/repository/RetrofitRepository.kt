package com.example.challenger.data.repository

import com.example.challenger.BuildConfig
import com.example.challenger.data.remote.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository() {
    private val api: NewsApi

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(NewsApi::class.java)

    }

    suspend fun getNews() = api.getNews(BuildConfig.SOURCE, BuildConfig.api_key)
}