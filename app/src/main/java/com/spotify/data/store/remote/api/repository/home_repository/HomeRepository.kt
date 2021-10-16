package com.spotify.data.store.remote.api.repository.home_repository

import com.spotify.data.store.remote.api.ApiManager

class HomeRepository(private val apiManager: ApiManager) {

    suspend fun fetchBandShowMain() = apiManager.getBandService().fetchBandShowMain()
}