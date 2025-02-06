package com.ingeacev.mymeliaplication.home.data.model.local

import com.google.gson.annotations.SerializedName

data class ItemDescriptionDao(
    @SerializedName("text") val text: String?,
    @SerializedName("plain_text") val plainText: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("date_created") val dateCreated: String,
    @SerializedName("snapshot") val snapshot: SnapshotDao
)

data class SnapshotDao(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("status") val status: String
)