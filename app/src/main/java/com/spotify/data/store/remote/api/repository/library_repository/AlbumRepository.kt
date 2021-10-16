package com.spotify.data.store.remote.api.repository.library_repository

import com.spotify.data.store.remote.api.ApiManager

class AlbumRepository(private val apiManager: ApiManager) {

    suspend fun fetchLibraryAlbumShowMain() = apiManager.getAlbumService().fetchLibraryAlbum()
}