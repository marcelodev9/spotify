package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class ArtistsLibraryShowMain (
    @SerializedName("artistsLibraryList")
    val artistsLibraryList: ArrayList<ArtistsLibrary>)