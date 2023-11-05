package com.example.challenger.ui.viewmodel

import Article
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenger.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class HomeNewsViewModel : ViewModel() {
    val articlesLiveData = MutableLiveData<List<Article>>()

    private var retrofitRepository =  RetrofitRepository()

    fun fetchArticles() {
        viewModelScope.launch {
            val response = retrofitRepository.getNews()
            articlesLiveData.postValue(response.body()?.articles
                ?.filter {
                    !it.title.isNullOrBlank()
                            && !it.author.isNullOrBlank()
                            && !it.urlToImage.isNullOrBlank()
                            && !it.url.isNullOrBlank()
                            && !it.content.isNullOrBlank()
                            && !it.publishedAt.isNullOrBlank()
                            && !it.description.isNullOrBlank()
                            && !it.source?.id.isNullOrBlank()
                            && !it.source?.name.isNullOrBlank()
                }
                ?.sortedBy { it.publishedAt })
        }
    }
}