package com.jeffery.androidapp.util

/**
 * Sealed class representing the different states of a data request.
 * @param T The type of data returned upon success.
 */
sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val error: Throwable) : RequestState<Nothing>()
}