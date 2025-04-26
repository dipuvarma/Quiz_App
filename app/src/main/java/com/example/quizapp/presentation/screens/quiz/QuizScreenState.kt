package com.example.quizapp.presentation.screens.quiz

import com.example.quizapp.domain.model.QuizUI
import com.example.quizapp.utils.Response

data class QuizScreenState(
    val isLoading: Boolean = false,
    val data: List<QuizUI> = emptyList(),
    val error: String = "",
)
