package com.spotify.data.store.remote.api.repository.search_repository

import com.spotify.data.store.remote.api.ApiManager

class SearchRepository(private val apiManager: ApiManager) {

    suspend fun fetchSearchCategory() = apiManager.getSearchService().fetchSearchCategory()
}