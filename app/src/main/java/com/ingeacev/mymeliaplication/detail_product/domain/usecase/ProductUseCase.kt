package com.ingeacev.mymeliaplication.detail_product.domain.usecase

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {

    suspend operator fun invoke(product: String): Flow<Resource<ItemDescription>>
}