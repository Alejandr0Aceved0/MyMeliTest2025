package com.ingeacev.mymeliaplication.home.data.datasource.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import javax.inject.Inject

class GetCategoriesDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator,
) : GetCategoriesDataSource,
    BaseDataSource<SearchApi>(
        apiServiceGenerator
    ) {

    override suspend fun getCategories(): Resource<List<CategoriesDto>?> {
        return consumeService(SearchApi::class.java) {
            it.getCategories()
        }
    }
}