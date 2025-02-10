package com.ingeacev.mymeliaplication.detail_product.data.respository

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.model.remote.ItemDescriptionResponseDto
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import kotlinx.coroutines.flow.Flow

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

interface ProductRepository {

    suspend fun getProductDescription(product: String): Flow<Resource<ItemDescription>>
}