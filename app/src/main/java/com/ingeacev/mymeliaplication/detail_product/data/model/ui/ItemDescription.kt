package com.ingeacev.mymeliaplication.detail_product.data.model.ui

import com.ingeacev.mymeliaplication.detail_product.data.model.remote.SnapshotDto

/**
 * Created by Alejandro Acevedo on 09,febrero,2025
 */

data class ItemDescription(
    val text: String? = "",
    val plainText: String? = "",
    val lastUpdated: String? = "",
    val dateCreated: String? = "",
    val snapshot: SnapshotDto? = SnapshotDto("", 0, 0, "")
)