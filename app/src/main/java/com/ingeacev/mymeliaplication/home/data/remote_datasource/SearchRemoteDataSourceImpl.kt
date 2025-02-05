package com.ingeacev.mymeliaplication.home.data.remote_datasource

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator,
    private val searchApi: SearchApi
) : SearchRemoteDataSource,
    BaseDataSource<SearchApi>(
        apiServiceGenerator
    ) {

    //TODO: IMPLEMENT REPOSITORIES

    override suspend fun searchByInputChange(query: String): Resource<SearchResponseDto> {
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