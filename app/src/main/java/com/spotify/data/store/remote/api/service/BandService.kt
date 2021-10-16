package com.spotify.data.store.remote.api.service

import com.spotify.data.model.BandShowMain
import retrofit2.Response
import retrofit2.http.GET

interface BandService {

    @GET("fetchBandShowMain")
    suspend fun fetchBandShowMain(): Response<BandShowMain>
}