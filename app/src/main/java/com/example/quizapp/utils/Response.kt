package com.example.quizapp.utils

sealed class Response<T>(
    val message: String? = null,
    val data: T? = null,
) {
    class Loading<T> : Response<T>()
    class Success<T>(data: T) : Response<T>(data = data)
    class Error<T>(message: String) : Response<T>(message = message)
}