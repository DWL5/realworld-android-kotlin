package com.example.realworld_android_kotlin.view.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.realworld_android_kotlin.R



/**
 * A simple [Fragment] subclass.
 * Use the [FeedDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedDetailFragment : Fragment() {
    val args: FeedDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = args.article


    }
}