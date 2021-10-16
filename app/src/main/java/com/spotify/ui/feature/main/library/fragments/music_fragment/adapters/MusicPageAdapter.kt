package com.spotify.ui.feature.main.library.fragments.music_fragment.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.spotify.R
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.album.AlbumsFragment
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.artists.ArtistsFragment
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.playlist.PlaylistFragment

class MusicPageAdapter(fm: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fm) {
    private val fragmentList: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }

    init {
        fragmentList.add(PlaylistFragment.newInstance())
        fragmentList.add(ArtistsFragment.newInstance())
        fragmentList.add(AlbumsFragment.newInstance())
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
            0 -> context.getString(R.string.library_music_playlist)
            1 -> context.getString(R.string.library_music_artists)
            else -> context.getString(R.string.library_music_albums)
        }
    }
}