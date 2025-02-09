package com.ingeacev.mymeliaplication.home.domain.usecase

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import com.ingeacev.mymeliaplication.home.data.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

class SearchProductsUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository
) : SearchProductsUseCase {

    override suspend fun getDefaultProducts(): Flow<Resource<SearchResponseDto>> {
        return searchRepository.getDefaultProducts()
    }

    override suspend fun searchProducts(query: String): Flow<Resource<SearchResponseDto>> {
        return searchRepository.searchProduct(query = query)
    }
}
