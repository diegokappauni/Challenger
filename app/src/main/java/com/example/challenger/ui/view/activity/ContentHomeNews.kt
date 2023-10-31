package com.example.challenger.ui.view.activity

import Article
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.challenger.R
import com.example.challenger.databinding.ActivityContentHomeNewsBinding
import com.example.challenger.databinding.ActivityHomeNewsBinding

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

        binding.content.text = extra?.content


    }
}