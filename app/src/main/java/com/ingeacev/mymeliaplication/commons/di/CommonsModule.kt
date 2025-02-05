package com.ingeacev.mymeliaplication.commons.di

import android.content.Context
import com.ingeacev.mymeliaplication.MyMeliTestApplication
import com.ingeacev.mymeliaplication.commons.data.RemoteConstants.API_ROOT_URL
import com.ingeacev.mymeliaplication.commons.networking.SearchApi
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.core.utils.CONTENT_TYPE
import com.ingeacev.mymeliaplication.core.utils.CONTENT_TYPE_VALUE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonsModule {

    @Provides
    @Singleton
    fun provideApiServiceGenerator(
        @ApplicationContext context: Context
    ): ApiServiceGenerator {
        return ApiServiceGenerator(
            API_ROOT_URL,
            mutableMapOf(
                CONTENT_TYPE to CONTENT_TYPE_VALUE,
                "charset" to "utf-8"

            ),
            null,
            context
        )
    }

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MyMeliTestApplication {
        return app as MyMeliTestApplication
    }

    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }


    @Provides
    @Singleton
    fun provideSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }
}