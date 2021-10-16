package com.spotify.ui.feature.main.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.spotify.R
import com.spotify.ui.feature.main.library.adapters.LibraryPageAdapter

class LibraryFragment : Fragment() {

    private lateinit var notificationsViewModel: LibraryViewModel

    private lateinit var libraryPageAdapter: LibraryPageAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(LibraryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_library, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        libraryPageAdapter =
            LibraryPageAdapter(childFragmentManager, requireActivity().applicationContext)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = libraryPageAdapter

        init()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun init() {
    }
}
