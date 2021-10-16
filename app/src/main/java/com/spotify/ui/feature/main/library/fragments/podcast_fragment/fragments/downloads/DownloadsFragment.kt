package com.spotify.ui.feature.main.library.fragments.podcast_fragment.fragments.downloads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.spotify.R

class DownloadsFragment : Fragment() {

    companion object {
        fun newInstance() =
            DownloadsFragment()
    }

    private lateinit var viewModel: DownloadsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library_podcast_downloads, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DownloadsFragmentViewModel::class.java)
    }

}