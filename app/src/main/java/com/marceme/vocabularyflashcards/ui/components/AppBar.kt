package com.marceme.mvocabulary.ui.theme.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.marceme.mvocabulary.ui.theme.ui.navigation.Screen
import com.marceme.vocabularyflashcards.ui.theme.ToolbarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardAppBar(
    onAddIconClicked: () -> Unit,
    onRepeatIconClicked: () -> Unit,
    currentRoute: String,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (currentRoute) {
        Screen.FlashCard.route -> {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ToolbarColor,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                title = { Text("Flashcards", fontWeight = FontWeight.Medium) },
                actions = {
                    IconButton(onClick = onAddIconClicked) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                    }
                    IconButton(onClick = onRepeatIconClicked) {
                        Icon(imageVector = Icons.Filled.Repeat, contentDescription = "Shuffle")
                    }
                })
        }

        Screen.AddWord.route -> {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ToolbarColor,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ),
                title = { Text("Create a card") },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                })
        }
    }
}