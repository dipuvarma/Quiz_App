package com.example.quizapp.presentation.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizapp.presentation.common.TopAppBarComp
import com.example.quizapp.presentation.screens.quiz.component.QuizShowComp
import com.example.quizapp.utils.Constants

@Composable
fun QuizScreen(
    questions: Int,
    category: String,
    difficulty: String,
    navController: NavHostController,
    viewModel: QuizScreenViewModel,
    event: (QuizScreenEvent) -> Unit,
    type: String,
) {

    val quizState = viewModel.quizState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        val difficulty = when (difficulty) {
            "Easy" -> "easy"
            "Medium" -> "medium"
            else -> "hard"
        }

        val type = when (type) {
            "Multiple Choice" -> "multiple"
            else -> "boolean"
        }

        event(
            QuizScreenEvent.GetQuizList(
                numOfQuiz = questions,
                category = Constants.categoriesMap[category]!!,
                difficulty = difficulty,
                type = type
            )
        )
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        TopAppBarComp(
            title = category,
            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
            onClickNavigationIcon = { navController.popBackStack() }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Quiz : $questions",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Text(
                text = difficulty,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        QuizShowComp(
            qNumber = 1,
            quizQuestion = "In what year did the Great October Socialist Revolution take place?"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .height(56.dp),
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContentColor = MaterialTheme.colorScheme.primary
                ),
            ) {
                Text(
                    text = "Previous",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .height(56.dp),
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}