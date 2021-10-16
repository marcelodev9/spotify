package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spotify.R
import com.spotify.data.model.AlbumLibrary
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.album.adapters.RecyclerViewListAdapter
import kotlinx.android.synthetic.main.fragment_library_music_playlists.*
import org.koin.android.viewmodel.ext.android.viewModel

class AlbumsFragment : Fragment() {

    companion object {
        fun newInstance() =
            AlbumsFragment()
    }

    private val viewModel: AlbumsFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library_music_album, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.albumLibraryList.observe(viewLifecycleOwner, Observer {
            setupRecyclerViewAdapter(it)
        })
    }

    private fun setupRecyclerViewAdapter(albumLibrary: ArrayList<AlbumLibrary>) {
        val recyclerViewListAdapter =
            RecyclerViewListAdapter(requireActivity().applicationContext, albumLibrary)
        val layoutManagerMain: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerViewLibrary.layoutManager = layoutManagerMain
        recyclerViewLibrary.setHasFixedSize(true)
        recyclerViewLibrary.adapter = recyclerViewListAdapter
    }

}