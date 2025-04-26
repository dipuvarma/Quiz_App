package com.example.quizapp.data.remote

import com.example.quizapp.data.dto.QuizDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApiServices {

    @GET("api.php")
    suspend fun getQuizList(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): QuizDTO

}