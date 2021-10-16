package com.spotify.ui.feature.main.library.fragments.podcast_fragment.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.spotify.R
import com.spotify.ui.feature.main.library.fragments.podcast_fragment.fragments.downloads.DownloadsFragment
import com.spotify.ui.feature.main.library.fragments.podcast_fragment.fragments.episodes.EpisodesFragment
import com.spotify.ui.feature.main.library.fragments.podcast_fragment.fragments.programs.ProgramsFragment

class PodcastPageAdapter(fm: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fm) {
    private val fragmentList: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }

    init {
        fragmentList.add(EpisodesFragment.newInstance())
        fragmentList.add(DownloadsFragment.newInstance())
        fragmentList.add(ProgramsFragment.newInstance())
    }

    override fun getCount(): Int = fragmentList.size

    override fun getItem(i: Int): Fragment {
        val fragment = fragmentList[i]
        fragment.arguments = Bundle().apply {
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.getString(R.string.library_podcast_episodes)
            1 -> context.getString(R.string.library_podcast_downloads)
            else -> context.getString(R.string.library_podcast_programs)
        }
    }
}