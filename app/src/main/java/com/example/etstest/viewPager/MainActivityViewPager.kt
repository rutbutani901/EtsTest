package com.downloader.hd.allvideodownloader.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class MainActivityViewPager (fragmentactivity: FragmentActivity, var fraglist:ArrayList<Fragment>) : FragmentStateAdapter(fragmentactivity) {

    override fun getItemCount(): Int {
        return fraglist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fraglist[position]
    }
}