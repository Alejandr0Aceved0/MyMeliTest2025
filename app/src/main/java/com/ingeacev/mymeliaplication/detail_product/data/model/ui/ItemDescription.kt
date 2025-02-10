package com.ingeacev.mymeliaplication.detail_product.data.model.ui

import com.ingeacev.mymeliaplication.home.data.model.remote.InstallmentsDto
import com.ingeacev.mymeliaplication.home.data.model.remote.ShippingDto

/**
 * Created by Alejandro Acevedo on 09,febrero,2025
 */

data class ItemDescription(
    val id: String,
    val siteId: String,
    val title: String,
    val plainText: String,
    val price: Double,
    val currencyId: String,
    val availableQuantity: Int,
    val condition: String,
    val permalink: String,
    val thumbnail: String,
    val acceptsMercadoPago: Boolean,
    val installments: InstallmentsDto?,
    val shipping: ShippingDto?,
    val categoryId: String,
    val officialStoreId: Int?,
    val lastUpdated: String? = "",
    val dateCreated: String? = "",
)
