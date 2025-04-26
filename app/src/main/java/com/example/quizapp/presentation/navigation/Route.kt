package com.example.quizapp.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeRoute


@Serializable
data class QuizRoute(
    val questions: Int,
    val category: String,
    val difficulty: String,
    val type: String
)