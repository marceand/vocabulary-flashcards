package com.marceme.vocabularyflashcards

import NavigationStack
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.marceme.mvocabulary.ui.theme.model.words
import com.marceme.mvocabulary.ui.theme.ui.components.FlashCardAppBar
import com.marceme.mvocabulary.ui.theme.ui.navigation.Screen
import com.marceme.vocabularyflashcards.ui.theme.VocabularyFlashCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VocabularyFlashCardsTheme(dynamicColor = false) {
                WordFlashCardApp()
            }
        }
    }
}

@Composable
fun WordFlashCardApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: Screen.FlashCard.route

    Scaffold(
        topBar = {
            FlashCardAppBar(
                onAddIconClicked = { navController.navigate(Screen.AddWord.route) },
                onRepeatIconClicked = { },
                currentRoute = currentRoute,
                navigateUp = { navController.navigateUp() }
            )
        },
        content = {
            WordCardContent(navController, it)
        }
    )
}

@Composable
fun WordCardContent(navController: NavHostController, paddingValues: PaddingValues) {
    val states = words.reversed()
        .map { it to rememberSwipeableCardState() }
    NavigationStack(paddingValues, navController, states = states)
}