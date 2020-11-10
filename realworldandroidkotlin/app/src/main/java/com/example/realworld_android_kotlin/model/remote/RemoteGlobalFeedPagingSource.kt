package com.example.realworld_android_kotlin.model.remote

import android.util.Log
import androidx.paging.PagingSource
import com.example.realworld_android_kotlin.model.data.Article
import com.example.realworld_android_kotlin.model.data.Articles
import com.example.realworld_android_kotlin.model.remote.network.RealWordApi
import java.lang.Exception
import javax.inject.Inject

class RemoteGlobalFeedPagingSource @Inject constructor(private val realWordService: RealWordApi) :
    PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val offset = params.key ?: 0
            val response = realWordService.getArticles(offset = offset)
            LoadResult.Page(
                data = response.body()?.articles ?: emptyList(),
                prevKey = null,
                nextKey = offset + 20
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}