package com.ingeacev.mymeliaplication.detail_product.data.respository

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import kotlinx.coroutines.flow.Flow

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

fun interface ProductRepository {

    fun getProductDescription(product: SearchResultDto): Flow<Resource<ItemDescription>>
}