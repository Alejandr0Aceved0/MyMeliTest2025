package com.ingeacev.mymeliaplication.home.data.remote_datasource

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import javax.inject.Inject

class GetCategoriesRemoteDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator,
    private val searchApi: SearchApi
): GetCategoriesRemoteDataSource,
    BaseDataSource<SearchApi>(
        apiServiceGenerator
    ) {

    //TODO: IMPLEMENT REPOSITORIES

    override suspend fun getCategories(): Resource<List<CategoriesDto>> {
        return try {
            val response = searchApi.getCategories()
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