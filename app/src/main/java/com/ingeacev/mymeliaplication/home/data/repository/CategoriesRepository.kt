package com.ingeacev.mymeliaplication.home.data.repository

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    suspend fun getCategories(): Flow<Resource<List<CategoriesDto>>>
}