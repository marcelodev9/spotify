package com.spotify.ui.feature.main.library.fragments.music_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.spotify.R
import com.spotify.ui.feature.main.library.fragments.music_fragment.adapters.MusicPageAdapter

class MusicFragment : Fragment() {
    private lateinit var musicPageAdapter: MusicPageAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_library_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        musicPageAdapter =
            MusicPageAdapter(childFragmentManager, requireActivity().applicationContext)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = musicPageAdapter

        }
}