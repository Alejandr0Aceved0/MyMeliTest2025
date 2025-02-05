package com.ingeacev.mymeliaplication.commons.data.datasource

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.service.ApiServiceGenerator
import com.ingeacev.mymeliaplication.core.utils.ResourceBuilder
import retrofit2.Response

/**
 * @author Juan Camilo Collantes Tovar on 09/07/2024
 * **/
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