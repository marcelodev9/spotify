package com.spotify.data.model

import com.google.gson.annotations.SerializedName

data class CategoryMain(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("categoryList")
    val categoryList: ArrayList<Category>
)