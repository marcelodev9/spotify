package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class BandShowMain(
    @SerializedName("bandList") val bandList: ArrayList<Band>,
    @SerializedName("bandShowMainList") val bandShowMainList: ArrayList<BandShow>
)