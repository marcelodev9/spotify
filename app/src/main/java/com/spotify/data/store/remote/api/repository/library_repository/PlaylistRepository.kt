package com.spotify.data.store.remote.api.repository.library_repository

import com.spotify.data.store.remote.api.ApiManager

class PlaylistRepository(private val apiManager: ApiManager) {

    suspend fun fetchPlaylistShowMain() = apiManager.getPlaylistService().fetchLibraryPlayList()
}