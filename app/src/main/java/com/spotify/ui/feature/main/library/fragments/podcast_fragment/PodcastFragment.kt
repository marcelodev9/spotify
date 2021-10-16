package com.spotify.ui.feature.main.library.fragments.podcast_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.spotify.R
import com.spotify.ui.feature.main.library.fragments.podcast_fragment.adapters.PodcastPageAdapter

class PodcastFragment : Fragment() {
    private lateinit var podcastPageAdapter: PodcastPageAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_library_podcast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        podcastPageAdapter =
            PodcastPageAdapter(childFragmentManager, requireActivity().applicationContext)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = podcastPageAdapter

    }
}