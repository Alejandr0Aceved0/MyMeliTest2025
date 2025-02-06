package com.ingeacev.mymeliaplication.home.data.model.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.google.gson.annotations.SerializedName

data class ItemDescriptionResponseDto(
    @SerializedName("text") val text: String?,
    @SerializedName("plain_text") val plainText: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("date_created") val dateCreated: String,
    @SerializedName("snapshot") val snapshot: SnapshotDto
)

data class SnapshotDto(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("status") val status: String
)