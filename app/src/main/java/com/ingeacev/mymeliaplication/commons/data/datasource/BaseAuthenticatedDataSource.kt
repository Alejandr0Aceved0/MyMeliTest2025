package com.ingeacev.mymeliaplication.commons.data.datasource

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.core.utils.ResourceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseAuthenticatedDataSource<S>(
    private val apiServiceGenerator: ApiServiceGenerator
) {

     protected suspend fun <T> consumeAuthenticatedService(
        clazz: Class<T>,
        apiCall: suspend (T) -> Response<T>
    ): Resource<T?> {
        return withContext(Dispatchers.IO) {
            try {
                val service = apiServiceGenerator.createService(clazz)
                val response = apiCall(service)
                if (response.isSuccessful) {
                    Resource.Success(response.body())
                } else {
                    Resource.Error(response.message())
                }
            } catch (e: Exception) {
                Resource.Error(e.message ?: "An unexpected error occurred.")
            }
        }
    }
}