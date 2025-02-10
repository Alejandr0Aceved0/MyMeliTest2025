package com.ingeacev.mymeliaplication.detail_product.data.datasource.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.detail_product.data.model.remote.ItemDescriptionResponseDto
import javax.inject.Inject

class GetProductDescriptionDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator,
) : GetProductDescriptionDataSource,
    BaseDataSource<SearchApi>(
        apiServiceGenerator
    ) {

    override suspend fun getItemDescription(product: String): Resource<ItemDescriptionResponseDto?> {
        return consumeService(SearchApi::class.java) {
            it.getItemDescription(product)
        }
    }
}