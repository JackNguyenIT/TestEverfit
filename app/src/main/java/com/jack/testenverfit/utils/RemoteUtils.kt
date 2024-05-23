package com.jack.testenverfit.utils

import com.jack.testenverfit.api.ResultApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T> handleApiResponse(requestApi: suspend () -> T): Flow<ResultApi<T>> {
    return flow {
        try {
            emit(ResultApi.Success(requestApi.invoke()))
        } catch (e: Exception) {
            emit(ResultApi.Error(e))
        }
    }
}
