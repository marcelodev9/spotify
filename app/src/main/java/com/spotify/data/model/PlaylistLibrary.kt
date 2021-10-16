package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class PlaylistLibrary (
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String)