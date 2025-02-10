package com.ingeacev.mymeliaplication.detail_product.data.model.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.google.gson.annotations.SerializedName
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto

data class ItemDescriptionResponseDto(
    @SerializedName("text") val text: String? = "",
    @SerializedName("plain_text") val plainText: String? = "",
    @SerializedName("last_updated") val lastUpdated: String? = "",
    @SerializedName("date_created") val dateCreated: String? = "",
    @SerializedName("snapshot") val snapshot: SnapshotDto = SnapshotDto("", 0, 0, "")
)

fun ItemDescriptionResponseDto.toItemDescription(searchResultDto: SearchResultDto) =
    ItemDescription(
        id = searchResultDto.id.toString(),
        siteId = searchResultDto.siteId.toString(),
        title = searchResultDto.title.toString(),
        plainText = this.plainText.toString(),
        price = searchResultDto.price ?: 0.0,
        currencyId = searchResultDto.currencyId.toString(),
        availableQuantity = searchResultDto.availableQuantity ?: 0,
        condition = searchResultDto.condition.toString(),
        permalink = searchResultDto.permalink.toString(),
        thumbnail = searchResultDto.thumbnail.toString(),
        acceptsMercadoPago = searchResultDto.acceptsMercadoPago ?: false,
        installments = searchResultDto.installments,
        shipping = searchResultDto.shipping,
        categoryId = searchResultDto.categoryId.toString(),
        officialStoreId = searchResultDto.officialStoreId,
        lastUpdated = this.lastUpdated,
        dateCreated = this.dateCreated
    )

data class SnapshotDto(
    @SerializedName("url") val url: String? = "",
    @SerializedName("width") val width: Int? = 0,
    @SerializedName("height") val height: Int? = 0,
    @SerializedName("status") val status: String? = ""
)