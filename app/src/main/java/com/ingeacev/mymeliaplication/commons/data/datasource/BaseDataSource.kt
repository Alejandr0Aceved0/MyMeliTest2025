package com.ingeacev.mymeliaplication.commons.data.datasource

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.core.utils.ResourceBuilder
import retrofit2.Response

abstract class BaseDataSource<S>(
    private val apiServiceGenerator: ApiServiceGenerator
) {

    suspend fun <T> consumeService(
        serviceClass: Class<S>,
        responseCall: suspend (S) -> Response<T?>
    ): Resource<T?> {
        var resource: Resource<T?>

        val service = apiServiceGenerator.createService(serviceClass)
        val response = apiServiceGenerator.processCallWithError {
            responseCall(service)
        }
        resource = ResourceBuilder<T>().build(response)

        return resource
    }

}