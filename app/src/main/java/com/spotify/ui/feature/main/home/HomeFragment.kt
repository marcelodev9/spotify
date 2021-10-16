package com.spotify.ui.feature.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spotify.R
import com.spotify.data.model.Band
import com.spotify.data.model.BandShow
import com.spotify.ui.feature.main.home.adapters.GridViewListAdapter
import com.spotify.ui.feature.main.home.adapters.RecyclerViewListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.bandMainList.observe(viewLifecycleOwner, Observer {
            setupGridViewAdapter(it)
        })
        homeViewModel.bandShowMainList.observe(viewLifecycleOwner, Observer {
            setupRecyclerViewAdapter(it)
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun init() {
        val animation = AnimationUtils.loadAnimation(activity, R.anim.fade_in)
        constraintLayoutMain.startAnimation(animation)
    }

    private fun setupGridViewAdapter(bandMainList: ArrayList<Band>) {
        val adapter = GridViewListAdapter(requireActivity().applicationContext, bandMainList)
        gridViewMain.adapter = adapter
    }


    private fun setupRecyclerViewAdapter(bandShowMainList: ArrayList<BandShow>) {
        val recyclerViewListAdapter =
            RecyclerViewListAdapter(requireActivity().applicationContext, bandShowMainList)
        val layoutManagerMain: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recylerViewMain.layoutManager = layoutManagerMain
        recylerViewMain.setHasFixedSize(true)
        recylerViewMain.adapter = recyclerViewListAdapter
    }
}