package com.spotify.data.model
import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String) {
}