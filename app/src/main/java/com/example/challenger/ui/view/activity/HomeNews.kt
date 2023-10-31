package com.example.challenger.ui.view.activity

import Article
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import com.example.challenger.databinding.ActivityHomeNewsBinding
import com.example.challenger.ui.adapter.HomeNewsAdapter
import com.example.challenger.ui.listener.HomeNewsListener
import com.example.challenger.ui.viewmodel.HomeNewsViewModel

class HomeNews : AppCompatActivity(), HomeNewsListener {
    private lateinit var binding: ActivityHomeNewsBinding
    private val viewModel: HomeNewsViewModel by lazy {
        ViewModelProvider(this).get(HomeNewsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observar as alterações nos dados da ViewModel
        viewModel.articlesLiveData.observe(this) { articles ->
            setupRecyclerView(articles)
        }

        // Iniciar o carregamento dos artigos
        viewModel.fetchArticles()
    }

    private fun setupRecyclerView(articles: List<Article>) {
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)
        binding.recyclerNews.adapter = HomeNewsAdapter(articles, this, this)
    }

    override fun onItemClick(article: Article?) {

//        val bundle = Bundle().putParcelable("articles", article)
        val intent = Intent(this, ContentHomeNews::class.java)
        intent.putExtra("articles", article)
        startActivity(intent)
    }
}