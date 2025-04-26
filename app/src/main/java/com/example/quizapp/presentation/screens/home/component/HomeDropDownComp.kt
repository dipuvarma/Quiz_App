package com.example.quizapp.presentation.screens.home.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeDropDownComp(
    menuName: String,
    menuItemList: List<String>,
    onDropDownClick: (String) -> Unit,
    selectedText: String,
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = menuName,
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            fontWeight = FontWeight.SemiBold,

            )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier // Apply the passed modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium
                )
                .clickable {
                    expanded = true
                },
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedText,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    modifier = Modifier
                        .width(280.dp)
                        .padding(end = 8.dp), // Add some padding
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Icon(
                    imageVector = if (!expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Dropdown arrow", // Added content description for accessibility
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )

            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                menuItemList.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            )
                        },
                        onClick = {
                            onDropDownClick(option)
                            expanded = false // Close the dropdown after selection
                        },
                    )
                }
            }
        }
    }
}
