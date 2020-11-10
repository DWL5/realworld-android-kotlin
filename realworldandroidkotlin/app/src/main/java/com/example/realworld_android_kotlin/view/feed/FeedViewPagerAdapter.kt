package com.example.realworld_android_kotlin.view.feed

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FeedViewPagerAdapter (fragment:Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return FeedFragment()
    }

    override fun getItemCount(): Int = 1

}