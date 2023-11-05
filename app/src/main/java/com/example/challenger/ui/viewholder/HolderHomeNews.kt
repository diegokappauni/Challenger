package com.example.challenger.ui.viewholder

import Article
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenger.databinding.CardArticleBinding


class HolderHomeNews(private val binding: CardArticleBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article?) {
        binding.title.text = article?.title
        Glide.with(context).load(article?.urlToImage).into(binding.imageNew)
    }
}