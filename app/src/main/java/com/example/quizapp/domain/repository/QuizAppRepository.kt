package com.example.quizapp.domain.repository

import com.example.quizapp.domain.model.QuizUI


interface QuizAppRepository {
    suspend fun getQuizList(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<QuizUI>
}