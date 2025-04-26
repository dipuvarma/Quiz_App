package com.example.quizapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.quizapp.presentation.screens.home.HomeScreen
import com.example.quizapp.presentation.screens.home.HomeScreenViewModel
import com.example.quizapp.presentation.screens.quiz.QuizScreen

@Composable
fun QuizAppNavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val viewModel: HomeScreenViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(
                viewModel = viewModel,
                event = viewModel::onEvent,
                navController = navController
            )
        }
        composable<Quiz> {
            val arg = it.toRoute<Quiz>()
            QuizScreen(
                questions = arg.questions,
                category = arg.category,
                difficulty = arg.difficulty
            )
        }
    }
}