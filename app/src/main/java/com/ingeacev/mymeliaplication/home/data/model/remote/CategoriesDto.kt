package com.ingeacev.mymeliaplication.home.data.model.remote

import com.google.gson.annotations.SerializedName

data class CategoriesDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)