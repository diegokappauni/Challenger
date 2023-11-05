package com.example.challenger.ui.view.activity

import Article
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.challenger.databinding.ActivityContentHomeNewsBinding

class ContentHomeNews : AppCompatActivity() {
    private lateinit var binding: ActivityContentHomeNewsBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentHomeNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extra = intent.getParcelableExtra("articles", Article::class.java)

        Glide.with(this)
            .load(extra?.urlToImage).into(binding.imageArticle)

        binding.title.text = extra?.title
        binding.description.text = extra?.description
        binding.content.text = extra?.content


    }
}