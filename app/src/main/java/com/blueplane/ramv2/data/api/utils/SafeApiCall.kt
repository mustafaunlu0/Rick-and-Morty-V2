package com.blueplane.ramv2.data.api.utils

import com.blueplane.ramv2.data.model.NetworkResponse

inline fun <T> safeApiCall(apiCall : () -> T) : NetworkResponse<T> =
    try {
        NetworkResponse.Success(apiCall())
    }catch (e : Exception){
        NetworkResponse.Error(e)
    }
