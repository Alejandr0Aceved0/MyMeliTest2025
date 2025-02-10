package com.ingeacev.mymeliaplication.home.domain.id

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.detail_product.data.datasource.remote.GetProductDescriptionDataSource
import com.ingeacev.mymeliaplication.detail_product.data.datasource.remote.GetProductDescriptionDataSourceImpl
import com.ingeacev.mymeliaplication.detail_product.data.respository.ProductRepository
import com.ingeacev.mymeliaplication.detail_product.data.respository.ProductRepositoryImpl
import com.ingeacev.mymeliaplication.detail_product.domain.usecase.ProductUseCase
import com.ingeacev.mymeliaplication.detail_product.domain.usecase.ProductUseCaseImpl
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSource
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSourceImpl
import com.ingeacev.mymeliaplication.home.data.datasource.remote.SearchDataSource
import com.ingeacev.mymeliaplication.home.data.datasource.remote.SearchDataSourceImpl
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepository
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepositoryImpl
import com.ingeacev.mymeliaplication.home.data.repository.SearchRepository
import com.ingeacev.mymeliaplication.home.data.repository.SearchRepositoryImpl
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCase
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCaseImpl
import com.ingeacev.mymeliaplication.home.domain.usecase.SearchProductsUseCase
import com.ingeacev.mymeliaplication.home.domain.usecase.SearchProductsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ProductsModule {

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

    @Provides
    @Singleton
    fun provideSearchRepository(
        searchDataSource: SearchDataSource
    ): SearchRepository {
        return SearchRepositoryImpl(
            searchDataSource
        )
    }

    @Provides
    @Singleton
    fun provideSearchDataSource(
        apiServiceGenerator: ApiServiceGenerator,
    ): SearchDataSource {
        return SearchDataSourceImpl(
            apiServiceGenerator
        )
    }

    @Provides
    @Singleton
    fun provideSearchUseCases(
        searchRepository: SearchRepository
    ): SearchProductsUseCase {
        return SearchProductsUseCaseImpl(
            searchRepository
        )
    }


    @Provides
    @Singleton
    fun provideProductDescriptionRepository(
        getProductDescriptionDataSource: GetProductDescriptionDataSource
    ): ProductRepository {
        return ProductRepositoryImpl(
            getProductDescriptionDataSource
        )
    }

    @Provides
    @Singleton
    fun provideProductDescriptionDataSource(
        apiServiceGenerator: ApiServiceGenerator,
    ): GetProductDescriptionDataSource {
        return GetProductDescriptionDataSourceImpl(
            apiServiceGenerator
        )
    }

    @Provides
    @Singleton
    fun provideProductUseCases(
        productRepository: ProductRepository
    ): ProductUseCase {
        return ProductUseCaseImpl(
            productRepository
        )
    }
}