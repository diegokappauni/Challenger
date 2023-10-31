package com.example.challenger.data.repository

import com.example.challenger.data.remote.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitRepository {
    private val api: NewsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(NewsApi::class.java)

    }

        suspend fun getNews() = api.getNews("us", "7a93b2223a0040379d136711e0e235a5")
}