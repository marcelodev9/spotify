package com.spotify.data.store.remote.api.service

import com.spotify.data.model.CategoryShowMain
import retrofit2.Response
import retrofit2.http.GET

interface SearchService {

    @GET("fetchSearchCategory")
    suspend fun fetchSearchCategory(): Response<CategoryShowMain>
}