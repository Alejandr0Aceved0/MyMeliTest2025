package com.ingeacev.mymeliaplication.home.domain.id

import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSource
import com.ingeacev.mymeliaplication.home.data.datasource.remote.GetCategoriesDataSourceImpl
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepository
import com.ingeacev.mymeliaplication.home.data.repository.CategoriesRepositoryImpl
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


//    @Provides
//    @Singleton
//    fun provideSendAbandonedDocumentsUseCase(
//        abandonedDocumentsRepository: AbandonedDocumentsRepository
//    ): SendAbandonedDocumentsUseCase {
//        return SendAbandonedDocumentsUseCaseImpl(abandonedDocumentsRepository)
//    }
}