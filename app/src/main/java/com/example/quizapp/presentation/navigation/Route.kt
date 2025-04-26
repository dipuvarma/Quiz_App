package com.example.quizapp.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object Home


@Serializable
data class Quiz(
    val questions: Int,
    val category: String,
    val difficulty: String
)