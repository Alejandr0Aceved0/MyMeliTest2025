package com.ingeacev.mymeliaplication.core.data.model

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
    val status: Status
) {
    class Success<T>(data: T) : Resource<T>(data, null, Status.SUCCESS)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message, Status.ERROR)
    class Loading<T>(data: T? = null) : Resource<T>(data, null, Status.LOADING)
    class Idle<T> : Resource<T>(null, null, Status.IDLE)
    class GenericError<T>(val errorCode:Int?, message: String, data: T? = null) : Resource<T>(data, message, Status.ERROR)

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        IDLE
    }

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$message]"
            is Loading -> "Loading"
            is Idle -> "Idle"
            is GenericError -> "Error[exception=$errorCode]"
        }
    }
}