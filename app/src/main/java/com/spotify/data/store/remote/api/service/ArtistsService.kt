package com.spotify.data.store.remote.api.service

import com.spotify.data.model.ArtistsLibraryShowMain
import retrofit2.Response
import retrofit2.http.GET

interface ArtistsService {

    @GET("fetchLibraryArtist")
    suspend fun fetchLibraryArtist(): Response<ArtistsLibraryShowMain>
}