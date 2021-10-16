package com.spotify.data.di

import com.spotify.data.store.remote.api.ApiManager
import com.spotify.data.store.remote.api.repository.home_repository.HomeRepository
import com.spotify.data.store.remote.api.repository.library_repository.AlbumRepository
import com.spotify.data.store.remote.api.repository.library_repository.ArtistsRepository
import com.spotify.data.store.remote.api.repository.library_repository.PlaylistRepository
import com.spotify.data.store.remote.api.repository.search_repository.SearchRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        HomeRepository(get())
    }
    single {
        SearchRepository(get())
    }
    single {
        PlaylistRepository(get())
    }
    single {
        ArtistsRepository(get())
    }
    single {
        AlbumRepository(get())
    }
}