package com.ingeacev.mymeliaplication.home.data.datasource.remote

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import javax.inject.Inject

class GetCategoriesDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator,
): GetCategoriesDataSource,
    BaseDataSource<SearchApi>(
        apiServiceGenerator
    ) {

    override suspend fun getCategories(): Resource<List<CategoriesDto>> {
            return consumeService(SearchApi::class.java) {
                it.getCategories()
            }

        return try {
            val response = searchApi.searchByInputChange(query)
            if (response.isSuccessful) {
                Resource.Success(response.body())
            } else {
                Resource.GenericDataError()
            }
        } catch (e: Exception) {
            Resource.GenericDataError()
        }
    }
        }
}