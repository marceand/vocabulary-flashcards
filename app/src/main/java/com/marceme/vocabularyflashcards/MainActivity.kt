package com.marceme.vocabularyflashcards

import NavigationStack
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.marceme.mvocabulary.ui.theme.model.words
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

    val states = words.reversed()
        .map { it to rememberSwipeableCardState() }
    NavigationStack(navController, states = states)
//    WordCardContent(modifier, navController)

//    Scaffold(
//        topBar = {
//            FlashCardAppBar(
//                onAddIconClicked = { navController.navigate(Screen.AddWord.route) },
//                onRepeatIconClicked = { },
//                currentRoute = currentRoute,
//                navigateUp = { navController.navigateUp() }
//            )
//        },
//        content = {
//            WordCardContent(navController, it)
//        }
//    )
}

@Composable
fun WordCardContent(modifier: Modifier = Modifier, navController: NavHostController) {
    val states = words.reversed()
        .map { it to rememberSwipeableCardState() }
    NavigationStack(navController, states = states)
}