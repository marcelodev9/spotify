package com.spotify.data.store.remote.api.service

import com.spotify.data.model.PlaylistLibraryShowMain
import retrofit2.Response
import retrofit2.http.GET

interface PlaylistService {

    @GET("fetchLibraryPlayList")
    suspend fun fetchLibraryPlayList(): Response<PlaylistLibraryShowMain>
}