package com.ingeacev.mymeliaplication.home.data.datasource.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.detail_product.data.model.remote.ItemDescriptionResponseDto
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator
) : SearchDataSource,
    BaseDataSource<SearchApi>(
        apiServiceGenerator
    ) {

    override suspend fun searchByInputChange(query: String): Resource<SearchResponseDto?> {
        return try {
            return consumeService(serviceClass = SearchApi::class.java) {
                it.searchByInputChange(query)
            }
        } catch (e: Exception) {
            Resource.GenericDataError()
        }
    }

    override suspend fun getDefaultProducts(): Resource<SearchResponseDto?> {
        return consumeService(SearchApi::class.java) {
            it.searchByDefault()
        }
    }

    override suspend fun geItemDescriptionById(itemId: String): Resource<ItemDescriptionResponseDto?> {
        return try {
            return consumeService(serviceClass = SearchApi::class.java) {
                it.getItemDescription(itemId)
            }
        } catch (e: Exception) {
            Resource.GenericDataError()
        }
    }
}