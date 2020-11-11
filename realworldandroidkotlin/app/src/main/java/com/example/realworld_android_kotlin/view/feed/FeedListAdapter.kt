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

class FeedListAdapter(diffCallback: DiffUtil.ItemCallback<Article>, private val onItemClickListener: OnItemClickListener) :
    PagingDataAdapter<Article, FeedListAdapter.FeedViewHolder>(diffCallback) {

    interface OnItemClickListener {
        fun clickItem(article: Article?)
    }

    inner class FeedViewHolder(private val binding: ItemFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article?) {
            if (article == null) return
            binding.article = article
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onItemClickListener.clickItem(getItem(position))
        }
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