package com.spotify.ui.feature.main.library.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.spotify.R
import com.spotify.ui.feature.main.library.fragments.music_fragment.MusicFragment
import com.spotify.ui.feature.main.library.fragments.podcast_fragment.PodcastFragment

class LibraryPageAdapter(fm: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fm) {
    private val fragmentList: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }

    init {
        fragmentList.add(MusicFragment())
        fragmentList.add(PodcastFragment())
    }

    override fun getCount(): Int = fragmentList.size

    override fun getItem(i: Int): Fragment {
        val fragment = fragmentList[i]
        fragment.arguments = Bundle().apply {
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0) context.getString(R.string.library_music) else context.getString(R.string.library_podcast)
    }
}