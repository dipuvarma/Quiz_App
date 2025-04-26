package com.example.quizapp.data.repository

import com.example.quizapp.data.remote.QuizApiServices
import com.example.quizapp.domain.model.QuizUI
import com.example.quizapp.domain.repository.QuizAppRepository
import javax.inject.Inject

class QuizAppRepositoryImpl @Inject constructor(
    private val quizApi: QuizApiServices,
) : QuizAppRepository {

    override suspend fun getQuizList(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String,
    ): List<QuizUI> {
        return quizApi.getQuizList(amount, category, difficulty, type).results.map {
            QuizUI(
                category = it.category,
                correct_answer = it.correct_answer,
                difficulty = it.difficulty,
                incorrect_answers = it.incorrect_answers,
                question = it.question,
                type = it.type
            )
        }
    }
}