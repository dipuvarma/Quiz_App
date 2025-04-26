package com.example.quizapp.presentation.screens.home

data class HomeScreenState(
    val questions: Int = 10,
    val category: String = "General Knowledge",
    val difficulty: String = "Easy",
    val type: String = "Multiple Choice",
)
