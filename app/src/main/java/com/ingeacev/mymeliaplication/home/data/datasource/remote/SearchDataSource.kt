package com.ingeacev.mymeliaplication.home.data.datasource.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.ItemDescriptionResponseDto
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto

interface SearchDataSource {

    suspend fun searchByInputChange(query: String): Resource<SearchResponseDto?>

    suspend fun getDefaultProducts(): Resource<SearchResponseDto?>

    suspend fun geItemDescriptionById(query: String): Resource<ItemDescriptionResponseDto?>
}