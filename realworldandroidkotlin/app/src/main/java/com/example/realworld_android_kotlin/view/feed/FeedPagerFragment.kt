package com.example.realworld_android_kotlin.view.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.realworld_android_kotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FeedPagerFragment : Fragment() {
    private lateinit var feedViewPagerAdapter: FeedViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        feedViewPagerAdapter = FeedViewPagerAdapter(this)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = feedViewPagerAdapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position->
            tab.text = "Global Feed"
        }.attach()
    }
}

