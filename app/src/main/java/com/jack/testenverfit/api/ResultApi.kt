package com.jack.testenverfit.api

sealed class ResultApi<out R> {
    data class Success<out T>(val data: T?) : ResultApi<T>()
    data class Error(val exception: Exception) : ResultApi<Nothing>()
}