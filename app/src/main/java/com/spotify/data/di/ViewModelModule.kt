package com.spotify.data.di

import com.spotify.ui.feature.main.home.HomeViewModel
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.album.AlbumsFragmentViewModel
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.artists.ArtistsFragmentViewModel
import com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.playlist.PlaylistFragmentViewModel
import com.spotify.ui.feature.main.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        PlaylistFragmentViewModel(get())
    }
    viewModel {
        ArtistsFragmentViewModel(get())
    }
    viewModel {
        AlbumsFragmentViewModel(get())
    }
}