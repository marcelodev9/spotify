package com.spotify.data.store.remote.api.repository.library_repository

import com.spotify.data.store.remote.api.ApiManager

class ArtistsRepository(private val apiManager: ApiManager) {

    suspend fun fetchLibraryArtistShowMain() = apiManager.getArtistsService().fetchLibraryArtist()
}