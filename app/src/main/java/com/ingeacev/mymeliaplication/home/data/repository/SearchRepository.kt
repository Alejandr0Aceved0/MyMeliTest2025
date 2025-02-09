package com.ingeacev.mymeliaplication.home.data.repository

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import kotlinx.coroutines.flow.Flow

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

interface SearchRepository {

    suspend fun getDefaultProducts(): Flow<Resource<List<SearchResponseDto>>>

    suspend fun searchProduct(query: String): Flow<Resource<List<SearchResponseDto>>?>
}