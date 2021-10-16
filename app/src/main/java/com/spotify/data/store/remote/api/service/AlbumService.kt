package com.spotify.data.store.remote.api.service

import com.spotify.data.model.AlbumLibraryShowMain
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("fetchLibraryAlbum")
    suspend fun fetchLibraryAlbum(): Response<AlbumLibraryShowMain>
}