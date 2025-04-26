package com.example.quizapp.domain.useCase

import com.example.quizapp.data.repository.QuizAppRepositoryImpl
import com.example.quizapp.domain.model.QuizUI
import com.example.quizapp.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class QuizAppUseCase(
    private val quizRepository: QuizAppRepositoryImpl,
) {

    fun getQuizList(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String,
    ): Flow<Response<List<QuizUI>>> = flow {
        emit(Response.Loading())
        try {
            emit(Response.Success(quizRepository.getQuizList(amount, category, difficulty, type)))
        } catch (e: Exception) {
            emit(Response.Error(e.toString()))
        }

    }.flowOn(Dispatchers.IO)
}