package com.ingeacev.mymeliaplication.home.domain.usecase

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import kotlinx.coroutines.flow.Flow

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */
interface SearchProductsUseCase {

    suspend fun getDefaultProducts(): Flow<Resource<List<SearchResponseDto>>>

    suspend fun searchProducts(query: String): Flow<Resource<List<SearchResponseDto>>>
}