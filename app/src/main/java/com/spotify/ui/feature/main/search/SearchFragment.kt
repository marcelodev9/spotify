package com.spotify.ui.feature.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spotify.R
import com.spotify.data.model.CategoryMain
import com.spotify.ui.feature.main.search.adapters.RecyclerViewListAdapter
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        searchViewModel.categoryMainList.observe(viewLifecycleOwner, Observer {
            setupRecyclerViewAdapter(it)
        })
        return root
    }

    private fun setupRecyclerViewAdapter(categoryMainList: ArrayList<CategoryMain>) {
        val recyclerViewListAdapter = RecyclerViewListAdapter(requireActivity().applicationContext,  categoryMainList)
        val layoutManagerMain: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerViewMain.layoutManager = layoutManagerMain
        recyclerViewMain.setHasFixedSize(true)
        recyclerViewMain.adapter = recyclerViewListAdapter
    }
}