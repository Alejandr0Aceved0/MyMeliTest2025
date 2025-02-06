package com.ingeacev.mymeliaplication.home.data.datasource.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto


interface GetCategoriesDataSource {

    suspend fun getCategories(): Resource<List<CategoriesDto>?>
}