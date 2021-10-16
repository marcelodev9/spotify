package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class AlbumLibraryShowMain (
    @SerializedName("albumLibraryList")
    val albumLibraryList: ArrayList<AlbumLibrary>)