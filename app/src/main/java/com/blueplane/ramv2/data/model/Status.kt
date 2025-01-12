package com.blueplane.ramv2.data.model

enum class Status {
    SUCCESS,
    ERROR,
    LOADING;

    fun isLoading() = this == LOADING
    fun isError() = this == ERROR
    fun isSuccess() = this == SUCCESS
}