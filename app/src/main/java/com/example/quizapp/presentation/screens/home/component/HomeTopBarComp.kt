package com.example.quizapp.presentation.screens.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBarComp(
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(bottomStart = 48.dp, bottomEnd = 48.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(32.dp),
                imageVector = Icons.Default.Menu,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "Quiz App",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Icon(
                modifier = Modifier
                    .size(32.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }


}