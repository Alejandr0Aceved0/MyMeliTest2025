package com.ingeacev.mymeliaplication.core.utils

import com.ingeacev.mymeliaplication.core.data.model.ApiResponse
import com.ingeacev.mymeliaplication.core.data.model.GenericErrorApiResponse
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.core.data.model.SuccessApiResponse

class ResourceBuilder<T> {
    fun build(response : ApiResponse<T?>): Resource<T?> {
        return when (response) {
            is SuccessApiResponse<*> -> {
                val body = response.body as T
                Resource.Success(body)
            }
            else -> {
                Resource.GenericDataError(
                    (response as GenericErrorApiResponse).code,
                    response.message
                )
            }
        }
    }
}