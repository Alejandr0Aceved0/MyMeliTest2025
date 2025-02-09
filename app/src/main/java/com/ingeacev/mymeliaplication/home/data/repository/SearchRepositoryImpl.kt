package com.ingeacev.mymeliaplication.home.data.repository

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.datasource.remote.SearchDataSource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
    //TODO: ADD GetCategoriesLocalDataSource
) : SearchRepository {

    override suspend fun getDefaultProducts(): Flow<Resource<List<SearchResponseDto>>> {
        return flow {

            when (val response = searchDataSource.getDefaultProducts()) {
                is Resource.Success -> {
                    emit(Resource.Success(response.data))
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

    override suspend fun searchProduct(query: String): Flow<Resource<List<SearchResponseDto>>?> {
        return flow {
            when (val response = searchDataSource.searchByInputChange(query = query)) {
                is Resource.Success -> {
                    emit(Resource.Success(response.data))
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