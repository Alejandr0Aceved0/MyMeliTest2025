package com.ingeacev.mymeliaplication.detail_product.data.model.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.google.gson.annotations.SerializedName
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription

data class ItemDescriptionResponseDto(
    @SerializedName("text") val text: String? = "",
    @SerializedName("plain_text") val plainText: String? = "",
    @SerializedName("last_updated") val lastUpdated: String? = "",
    @SerializedName("date_created") val dateCreated: String? = "",
    @SerializedName("snapshot") val snapshot: SnapshotDto = SnapshotDto("", 0, 0, "")
)

fun ItemDescriptionResponseDto.toItemDescription() = ItemDescription (
    text = text,
    plainText = plainText,
    lastUpdated = lastUpdated,
    dateCreated = dateCreated,
    snapshot = snapshot
)

data class SnapshotDto(
    @SerializedName("url") val url: String? = "",
    @SerializedName("width") val width: Int? = 0,
    @SerializedName("height") val height: Int? = 0,
    @SerializedName("status") val status: String? = ""
)