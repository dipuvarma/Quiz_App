package com.example.quizapp.presentation.screens.quiz

sealed class QuizScreenEvent {

    data class GetQuizList(
        val numOfQuiz: Int,
        val category: Int,
        val difficulty: String,
        val type: String,
    ): QuizScreenEvent()

}