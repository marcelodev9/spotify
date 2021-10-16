package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class BandShow(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("bandList") val bandList: ArrayList<Band>,
    @SerializedName("type") val type: String
)