package com.ingeacev.mymeliaplication.home.data.repository

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import kotlinx.coroutines.flow.Flow

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

interface CategoriesRepository {

    suspend fun getCategories(): Flow<Resource<List<CategoriesDto>>>
}