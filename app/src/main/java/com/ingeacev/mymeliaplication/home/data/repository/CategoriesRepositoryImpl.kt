package com.ingeacev.mymeliaplication.home.data.repository

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val getCategoriesDataSource: GetCategoriesDataSource
    //TODO: ADD GetCategoriesLocalDataSource
) : CategoriesRepository {

    override suspend fun getCategories(): Flow<Resource<List<CategoriesDto>>> {
        return flow {
            when (val response = getCategoriesDataSource
                .getCategories()) {
                is Resource.Success -> {
                    emit(Resource.Success())
                }

                else -> {
                    emit(
                        Resource.GenericDataError(
                            response.errorCode,
                            response.errorMessage
                        )
                    )
                }
            }
        }
    }
}