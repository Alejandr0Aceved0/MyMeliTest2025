package com.ingeacev.mymeliaplication.home.domain.usecase

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCaseImpl @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) : GetCategoriesUseCase {

    override suspend fun invoke(): Flow<Resource<List<CategoriesDto>>> {
        return categoriesRepository.getCategories()
    }
}
