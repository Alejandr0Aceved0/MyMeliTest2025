package com.ingeacev.mymeliaplication.detail_product.data.datasource.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.model.remote.ItemDescriptionResponseDto


interface GetProductDescriptionDataSource {

    suspend fun getItemDescription(product: String): Resource<ItemDescriptionResponseDto?>
}