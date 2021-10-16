package com.spotify.data.store.remote.api

import com.spotify.BuildConfig
import com.spotify.data.store.remote.api.service.*
import retrofit2.Retrofit

class ApiManager {

    private val retrofit: Retrofit = ApiAdapterFactory.createAdapter(BuildConfig.API_ENDPOINT, null)

    private lateinit var bandService: BandService
    private lateinit var searchService: SearchService
    private lateinit var playlistService: PlaylistService
    private lateinit var artistsService: ArtistsService
    private lateinit var albumService: AlbumService

    @Synchronized
    fun getBandService(): BandService {
        if(!this::bandService.isInitialized) {
            bandService = retrofit.create(BandService::class.java)
        }

        return bandService
    }

    @Synchronized
    fun getSearchService(): SearchService {
        if(!this::searchService.isInitialized) {
            searchService = retrofit.create(SearchService::class.java)
        }

        return searchService
    }

    @Synchronized
    fun getPlaylistService(): PlaylistService {
        if(!this::playlistService.isInitialized) {
            playlistService = retrofit.create(PlaylistService::class.java)
        }

        return playlistService
    }

    @Synchronized
    fun getArtistsService(): ArtistsService {
        if(!this::artistsService.isInitialized) {
            artistsService = retrofit.create(ArtistsService::class.java)
        }

        return artistsService
    }

    @Synchronized
    fun getAlbumService(): AlbumService {
        if(!this::albumService.isInitialized) {
            albumService = retrofit.create(AlbumService::class.java)
        }

        return albumService
    }

}