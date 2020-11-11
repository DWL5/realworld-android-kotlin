package com.example.realworld_android_kotlin.view.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.realworld_android_kotlin.R
import com.example.realworld_android_kotlin.model.data.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FeedFragment : Fragment(), FeedListAdapter.OnItemClickListener {

    val viewModel by viewModels<FeedViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagingAdapter = FeedListAdapter(FeedListAdapter.ArticleComparator, this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = pagingAdapter
        Log.d("paging", "onViewCreated called.")
        lifecycleScope.launch {
            Log.d("paging", "launch called.")
            viewModel.globalFeedFlow.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }

    override fun clickItem(article: Article?) {
        article?.let {
            val action =
                FeedDetailFragmentDirections.actionToFeedDetailFragment(it)
            findNavController().navigate(action)
        }
    }
}