package com.example.realworld_android_kotlin.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import androidx.paging.cachedIn
import com.example.realworld_android_kotlin.model.remote.RemoteGlobalFeedPagingSource
import com.example.realworld_android_kotlin.model.repository.RealWorldRepository


class FeedViewModel@ViewModelInject constructor(
    private val remoteGlobalFeedPagingSource: RemoteGlobalFeedPagingSource,
    private val repository: RealWorldRepository
) : ViewModel() {



    val globalFeedFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        remoteGlobalFeedPagingSource
    }.flow.cachedIn(viewModelScope)

    fun getComments(slug:String) = repository.getCommentsFromArticle(slug)
    fun postFavoriteArticle(slug: String) = repository.favoriteArticle(slug)
    fun postUnFavoriteArticle(slug: String) = repository.unFavoriteArticle(slug)
}