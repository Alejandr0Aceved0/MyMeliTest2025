package com.ingeacev.mymeliaplication.home.data.remote_datasource

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto


interface GetCategoriesRemoteDataSource {

    suspend fun getCategories(): Resource<List<CategoriesDto>?>
}