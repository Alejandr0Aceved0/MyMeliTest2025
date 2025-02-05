package com.ingeacev.mymeliaplication.core.data.service

import android.content.Context
import android.util.Log
import com.ingeacev.mymeliaplication.core.data.model.ApiResponse
import com.ingeacev.mymeliaplication.core.data.model.GenericErrorApiResponse
import com.ingeacev.mymeliaplication.core.data.model.SuccessApiResponse
import com.ingeacev.mymeliaplication.core.utils.TIME_OUT_CONNECT
import com.ingeacev.mymeliaplication.core.utils.TIME_OUT_READ
import com.ingeacev.mymeliaplication.core.utils.isNetworkAvailable
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit



class ApiServiceGenerator(
    private val baseUrl: String,
    private val headers: MutableMap<String, String>? = null,
    private val queryParams: MutableMap<String, String>? = null,
    private val context: Context
) {

    private fun buildInterceptor() = Interceptor { chain ->
        var request = chain.request()

        val newBuilder = request.url.newBuilder()
        queryParams?.forEach { (key, value) ->
            newBuilder.addQueryParameter(key, value)
        }

        val url = newBuilder.build()

        request = request.newBuilder()
            .url(url)
            .headers(getHeaders(request))
            .method(request.method, request.body)
            .build()

        if (!isNetworkAvailable(context)) {
            throw NoConnectivityException()
        }
        chain.proceed(request)
    }

    fun addHeader(key: String, value: String) {
        headers?.put(key, value)
    }

    fun addHeaders(customHeaders: Map<String, String>) {
        customHeaders.map {
            headers?.put(it.key, it.value)
        }
    }

    fun addQueryParams(customQueryParams: Map<String, String>) {
        customQueryParams.map {
            queryParams?.put(it.key, it.value)
        }
    }

    private fun getHeaders(request: Request): Headers {
        val builder: Headers.Builder = Headers.Builder()
        headers?.forEach { (key, value) ->
            builder.add(key, value)
        }
        builder.addAll(request.headers)
        return builder.build()
    }

    private fun getClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(buildInterceptor())
        .connectTimeout(TIME_OUT_CONNECT.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIME_OUT_READ.toLong(), TimeUnit.SECONDS)
        .build()

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(baseUrl).client(getClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <S> createService(serviceClass: Class<S>): S {
        return getRetrofit().create(serviceClass)
    }

    suspend fun <Data> processCallWithError(responseCall: suspend () -> Response<Data>): ApiResponse<Data?> {

        val response: Response<Data>?
        return try {
            response = responseCall.invoke()
            if (response.isSuccessful) {
                Log.d(
                    "TAG_SUCCESS",
                    response.toString(),
                )
                SuccessApiResponse(response.body())
            } else {
                Log.d(
                    "TAG_FAILED",
                    response.toString(),
                )
                Log.d(
                    "TAG_FAILED",
                    response.message().toString(),
                )
                return GenericErrorApiResponse(
                    response.code(), if (response.message().isNullOrBlank()) {
                        response.errorBody()?.byteString()?.utf8().toString()
                    } else {
                        response.message()
                    }
                )
            }
        } catch (ex: NoConnectivityException) {
            GenericErrorApiResponse(-1, "No hay conexión a Internet")
        } catch (ex: Exception) {
            ex.message?.let {
                Log.e(
                    "TAG_EX",
                    it,
                )
            }
            Log.d(
                "TAG_STRING",
                ex.toString(),
            )
            GenericErrorApiResponse(ex.hashCode(), ex.message)
        }
    }
}

class NoConnectivityException : IOException("No hay conexión a Internet")