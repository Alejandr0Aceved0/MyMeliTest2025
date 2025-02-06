package com.ingeacev.mymeliaplication.home.domain.usecase

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import kotlinx.coroutines.flow.Flow

interface GetCategoriesRemoteUseCase {

    suspend operator fun invoke(): Flow<Resource<List<CategoriesDto>>>
}