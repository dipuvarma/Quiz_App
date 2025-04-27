package com.example.quizapp.domain.DI

import com.example.quizapp.data.remote.QuizApiServices
import com.example.quizapp.data.repository.QuizAppRepositoryImpl
import com.example.quizapp.domain.useCase.QuizAppUseCase
import com.example.quizapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Provides
    @Singleton
    fun provideQuizApi(): QuizApiServices {
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideQuizRepository(api: QuizApiServices): QuizAppRepositoryImpl {
        return QuizAppRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideQuizUseCase(quizAppRepositoryImpl: QuizAppRepositoryImpl): QuizAppUseCase {
        return QuizAppUseCase(quizRepository = quizAppRepositoryImpl)
    }

}