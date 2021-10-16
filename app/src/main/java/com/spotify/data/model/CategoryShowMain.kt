package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class CategoryShowMain(
    @SerializedName("categoryMainList")
    val categoryMainList: ArrayList<CategoryMain>
)