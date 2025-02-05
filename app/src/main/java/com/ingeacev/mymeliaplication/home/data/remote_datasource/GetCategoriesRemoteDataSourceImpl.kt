package com.ingeacev.mymeliaplication.home.data.remote_datasource

import com.ingeacev.mymeliaplication.commons.data.datasource.BaseAuthenticatedDataSource
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import javax.inject.Inject

class GetCategoriesRemoteDataSourceImpl @Inject constructor(
    apiServiceGenerator: ApiServiceGenerator
) : GetCategoriesRemoteDataSource, BaseAuthenticatedDataSource<SearchApi>(
    apiServiceGenerator
) {

    override suspend fun getCategories(): Resource<List<CategoriesDto>?> {
        TODO("Not yet implemented") //API REQUEST WITH ERROR
    }
}