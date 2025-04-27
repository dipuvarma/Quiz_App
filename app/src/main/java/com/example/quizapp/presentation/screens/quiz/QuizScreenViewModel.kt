package com.example.quizapp.presentation.screens.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.domain.useCase.QuizAppUseCase
import com.example.quizapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(
    private val quizAppUseCase: QuizAppUseCase,
) : ViewModel() {

    private val _quizState = MutableStateFlow(QuizScreenState())
    val quizState = _quizState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = QuizScreenState()
    )

    fun onEvent(event: QuizScreenEvent) {
        when (event) {
            is QuizScreenEvent.GetQuizList -> {
                getQuizList(event.numOfQuiz, event.category, event.difficulty, event.type)
            }
        }
    }

    fun getQuizList(amount: Int, category: Int, difficulty: String, type: String) {
        viewModelScope.launch {

            quizAppUseCase.getQuizList(amount, category, difficulty, type).collect {
                when (it) {
                    is Response.Loading -> {
                        Log.d("TAG", "Loading")
                        _quizState.value = quizState.value.copy(
                            isLoading = true
                        )
                    }

                    is Response.Error -> {
                        Log.d("TAG", "Error")
                        _quizState.value = quizState.value.copy(
                            error = it.message.toString()
                        )
                    }

                    is Response.Success -> {
                        Log.d("TAG", "Success")
                        for (quiz in it.data!!) {
                            Log.d("TAG", "getQuizList: $quiz")
                        }
                        _quizState.value = quizState.value.copy(
                            data = it.data,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}