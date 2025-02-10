package com.ingeacev.mymeliaplication.home.domain.usecase

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */
interface SearchProductsUseCase {

    suspend fun getDefaultProducts(): Flow<Resource<SearchItemResult>>

    suspend fun searchProducts(query: String): Flow<Resource<SearchItemResult>>
}