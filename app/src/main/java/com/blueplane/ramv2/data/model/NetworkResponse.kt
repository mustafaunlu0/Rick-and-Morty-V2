package com.blueplane.ramv2.data.model

sealed class NetworkResponse <out T : Any?>{

    data object Loading : NetworkResponse<Nothing>()
    data class Error(val error : Exception) : NetworkResponse<Nothing>()
    data class Success<out T : Any>(val data : T?) : NetworkResponse<T>()

    val isSuccess: Boolean
        get() = this is Success && data != null
}