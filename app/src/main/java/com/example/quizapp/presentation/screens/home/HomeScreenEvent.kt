package com.example.quizapp.presentation.screens.home

sealed class HomeScreenEvent {

    data class SetNumberOfQuestions(val numberOfQuestions: Int) : HomeScreenEvent()
    data class SetQuizCategory(val quizCategory: String) : HomeScreenEvent()
    data class SetQuizDifficulty(val quizDifficulty: String) : HomeScreenEvent()
    data class SetQuizType(val quizType: String) : HomeScreenEvent()
}