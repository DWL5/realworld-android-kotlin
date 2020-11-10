package com.example.realworld_android_kotlin.view.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.realworld_android_kotlin.R
import com.example.realworld_android_kotlin.databinding.ItemFeedBinding
import com.example.realworld_android_kotlin.model.data.Article

class FeedListAdapter(diffCallback: DiffUtil.ItemCallback<Article>) :
    PagingDataAdapter<Article, FeedListAdapter.FeedViewHolder>(diffCallback) {
    inner class FeedViewHolder(private val binding: ItemFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article?) {
            if (article == null) return
            binding.article = article
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = DataBindingUtil.inflate<ItemFeedBinding>(LayoutInflater.from(parent.context),
        R.layout.item_feed, parent, false)
        return FeedViewHolder(binding)
    }

    object ArticleComparator: DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.slug == newItem.slug
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem == newItem
        }

    }
}