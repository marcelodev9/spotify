package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class AlbumLibrary (
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String)