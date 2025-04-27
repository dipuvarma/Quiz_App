package com.example.quizapp.presentation.screens.quiz.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun QuizShowComp(
    qNumber: Int,
    quizQuestion: String,
) {

    val options = listOf(
        "A" to "Apple",
        "B" to "Banana",
        "C" to "Cherry",
        "D" to "Date"
    )

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$qNumber.",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = quizQuestion,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                maxLines = 3,

                )

        }
        Spacer(modifier = Modifier.height(24.dp))

        options.forEachIndexed { index, (option, quizText) ->
            if (quizText.isNotEmpty()) {
                QuizOptionComp(
                    qLetter = option,
                    qChoice = quizText,
                    isOptionSelected = false,
                    unSelectedOptionClick = {},
                    onOptionClick = { }
                )
            }
        }
    }

}