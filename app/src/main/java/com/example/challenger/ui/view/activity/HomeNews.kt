package com.example.challenger.ui.view.activity

import Article
import HomeNewsViewModelFactory
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import com.example.challenger.databinding.ActivityHomeNewsBinding
import com.example.challenger.ui.adapter.HomeNewsAdapter
import com.example.challenger.listener.HomeNewsListener
import com.example.challenger.ui.viewmodel.HomeNewsViewModel
import com.example.challenger.biometric.Biometric


class HomeNews : AppCompatActivity(), HomeNewsListener {
    private lateinit var binding: ActivityHomeNewsBinding
    private val viewModel: HomeNewsViewModel by lazy {
        val factory = HomeNewsViewModelFactory()
        ViewModelProvider(this, factory)[HomeNewsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val biometric = Biometric(this@HomeNews)
        biometric.setupBiometric { loadData() }
        biometric.isBiometricSupported(this@HomeNews)

    }

    private fun loadData() {
        viewModel.articlesLiveData.observe(this) { articles ->
            setupRecyclerView(articles)
        }

        viewModel.fetchArticles()
    }

    private fun setupRecyclerView(articles: List<Article?>) {
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)
        binding.recyclerNews.adapter = HomeNewsAdapter(articles, this, this)
    }

    override fun onItemClick(article: Article?) {
        val intent = Intent(this, ContentHomeNews::class.java)
        intent.putExtra("articles", article)
        startActivity(intent)
    }
}

