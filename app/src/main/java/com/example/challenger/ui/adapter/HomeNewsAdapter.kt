package com.example.challenger.ui.adapter

import Article
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenger.databinding.CardArticleBinding
import com.example.challenger.ui.listener.HomeNewsListener
import com.example.challenger.ui.viewholder.HolderHomeNews

class HomeNewsAdapter(
    private val listOfNews: List<Article>?,
    private val context: Context,
    private val listener: HomeNewsListener
) :
    RecyclerView.Adapter<HolderHomeNews>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderHomeNews {

        val view = CardArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HolderHomeNews(view, context)
    }

    override fun onBindViewHolder(holder: HolderHomeNews, position: Int) {
        holder.bind(listOfNews?.get(position))
        holder.itemView.setOnClickListener {
            listener.onItemClick(listOfNews?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return listOfNews?.size ?: 0
    }
}