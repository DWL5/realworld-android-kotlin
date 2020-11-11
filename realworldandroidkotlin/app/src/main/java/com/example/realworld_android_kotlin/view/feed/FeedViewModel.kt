package com.example.realworld_android_kotlin.view.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import androidx.paging.cachedIn
import com.example.realworld_android_kotlin.model.remote.RemoteGlobalFeedPagingSource


class FeedViewModel@ViewModelInject constructor(
    private val remoteGlobalFeedPagingSource: RemoteGlobalFeedPagingSource
) : ViewModel() {

    val globalFeedFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        remoteGlobalFeedPagingSource
    }.flow.cachedIn(viewModelScope)

}