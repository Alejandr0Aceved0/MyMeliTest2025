package com.ingeacev.mymeliaplication.core.data.model

sealed class ApiResponse <out Data>

data class SuccessApiResponse<out Data>(val body: Data) : ApiResponse<Data>()

data class GenericErrorApiResponse(val code: Int? = -1, val message: String? = "") :
    ApiResponse<Nothing>()