package com.ingeacev.mymeliaplication.home.domain.id

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSource
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSourceImpl
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepository
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepositoryImpl
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCase
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CategoriesModule {
    @Provides
    @Singleton
    fun provideCategoriesRepository(
        getCategoriesDataSource: GetCategoriesDataSource
    ): CategoriesRepository {
        return CategoriesRepositoryImpl(
            getCategoriesDataSource
        )
    }


    @Provides
    @Singleton
    fun provideCategoriesDataSource(
        apiServiceGenerator: ApiServiceGenerator,
    ): GetCategoriesDataSource {
        return GetCategoriesDataSourceImpl(
            apiServiceGenerator
        )
    }

    @Provides
    @Singleton
    fun provideCategoriesUseCases(
        categoriesRepository: CategoriesRepository
    ): GetCategoriesUseCase {
        return GetCategoriesUseCaseImpl(
            categoriesRepository
        )
    }
}