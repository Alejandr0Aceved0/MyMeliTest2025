package com.ingeacev.mymeliaplication.home.data.datasource.remote


import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto

interface SearchRemoteDataSource {

    suspend fun searchByInputChange(query: String): Resource<SearchResponseDto>
}