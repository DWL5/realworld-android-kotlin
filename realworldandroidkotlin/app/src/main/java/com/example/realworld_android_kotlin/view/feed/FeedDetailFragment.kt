package com.example.realworld_android_kotlin.view.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.realworld_android_kotlin.R
import com.example.realworld_android_kotlin.databinding.FragmentFeedDetailBinding
import com.example.realworld_android_kotlin.viewmodel.FeedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [FeedDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedDetailFragment : Fragment() {
    val args: FeedDetailFragmentArgs by navArgs()
    val viewModel: FeedViewModel by viewModels()

    lateinit var binding: FragmentFeedDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =
        return inflater.inflate(R.layout.fragment_feed_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = args.article
        article?.let {article
            viewModel.getComments(article.slug).observe(viewLifecycleOwner, Observer {
                when(it.status) {
                    com.example.realworld_android_kotlin.model.remote.Resource.Status.LOADING-> {

                    }

                    com.example.realworld_android_kotlin.model.remote.Resource.Status.SUCCESS -> {

                    }

                    com.example.realworld_android_kotlin.model.remote.Resource.Status.ERROR -> {

                    }

                }
            })
        }

    }
}