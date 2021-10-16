package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spotify.R
import com.spotify.data.model.PlaylistLibrary
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.playlist.adapters.RecyclerViewListAdapter
import kotlinx.android.synthetic.main.fragment_library_music_playlists.*
import org.koin.android.viewmodel.ext.android.viewModel

class PlaylistFragment : Fragment() {

    companion object {
        fun newInstance() =
            PlaylistFragment()
    }

    private val viewModel: PlaylistFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library_music_playlists, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.playListLibraryList.observe(viewLifecycleOwner, Observer {
            setupRecyclerViewAdapter(it)
        })
    }

    private fun setupRecyclerViewAdapter(playListLibrary: ArrayList<PlaylistLibrary>) {
        val recyclerViewListAdapter =
            RecyclerViewListAdapter(requireActivity().applicationContext, playListLibrary)
        val layoutManagerMain: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerViewLibrary.layoutManager = layoutManagerMain
        recyclerViewLibrary.setHasFixedSize(true)
        recyclerViewLibrary.adapter = recyclerViewListAdapter
    }

}