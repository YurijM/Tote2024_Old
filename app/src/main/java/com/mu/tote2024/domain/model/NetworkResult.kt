package com.mu.tote2024.domain.model

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T?) : NetworkResult<T>(data = data)
    class Fail<T>(message: String?) : NetworkResult<T>(message = message)
    class Loading<T> : NetworkResult<T>()
}
