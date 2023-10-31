package com.example.challenger.model

import Article

data class NewsResponse(val title: String) {
    val articles: List<Article>? = null
}