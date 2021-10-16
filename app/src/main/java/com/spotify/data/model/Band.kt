package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class Band(
    @SerializedName("name") val name: String,
    @SerializedName("description") val desription: String,
    @SerializedName("image") val image: String
)