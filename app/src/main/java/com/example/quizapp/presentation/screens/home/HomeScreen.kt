package com.example.quizapp.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizapp.presentation.navigation.Quiz
import com.example.quizapp.presentation.screens.home.component.HomeDropDownComp
import com.example.quizapp.presentation.screens.home.component.HomeTopBarComp
import com.example.quizapp.utils.Constants

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    event: (HomeScreenEvent) -> Unit,
    navController: NavHostController,
) {

    val state = viewModel.homeState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {

        HomeTopBarComp()
        Spacer(modifier = Modifier.height(32.dp))
        HomeDropDownComp(
            menuName = "Number Of Questions",
            menuItemList = Constants.numbersAsString,
            onDropDownClick = {
                event(HomeScreenEvent.SetNumberOfQuestions(it.toInt()))
            },
            selectedText = state.value.questions.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        HomeDropDownComp(
            menuName = "Select Category",
            menuItemList = Constants.categories,
            onDropDownClick = {
                event(HomeScreenEvent.SetQuizCategory(it))
            },
            selectedText = state.value.category
        )
        Spacer(modifier = Modifier.height(16.dp))

        HomeDropDownComp(
            menuName = "Select Difficulty ",
            menuItemList = Constants.difficulty,
            onDropDownClick = {
                event(HomeScreenEvent.SetQuizDifficulty(it))
            },
            selectedText = state.value.difficulty
        )
        Spacer(modifier = Modifier.height(16.dp))

        HomeDropDownComp(
            menuName = "Select Type",
            menuItemList = Constants.type,
            onDropDownClick = {
                event(HomeScreenEvent.SetQuizType(it))
            },
            selectedText = state.value.type
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(
                    Quiz(
                        questions = state.value.questions,
                        category = state.value.category,
                        difficulty = state.value.difficulty,
                        )
                )
                Log.d(
                    "TAG",
                    "${state.value.questions} ${state.value.category} ${state.value.difficulty} ${state.value.type}"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Generate Quiz",
                style = MaterialTheme.typography.titleLarge
            )
        }

    }

}