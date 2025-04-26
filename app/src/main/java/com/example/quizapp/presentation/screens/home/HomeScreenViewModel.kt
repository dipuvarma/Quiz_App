package com.example.quizapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn


class HomeScreenViewModel : ViewModel() {

    private val _homeState = MutableStateFlow(HomeScreenState())
    val homeState = _homeState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeScreenState()
    )


    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.SetNumberOfQuestions -> {
                _homeState.value = homeState.value.copy(
                    questions = event.numberOfQuestions
                )
            }

            is HomeScreenEvent.SetQuizCategory -> {
                _homeState.value = homeState.value.copy(
                    category = event.quizCategory
                )
            }

            is HomeScreenEvent.SetQuizDifficulty -> {
                _homeState.value = homeState.value.copy(
                    difficulty = event.quizDifficulty
                )
            }

            is HomeScreenEvent.SetQuizType -> {
                _homeState.value = homeState.value.copy(
                    type = event.quizType
                )
            }
        }
    }
}