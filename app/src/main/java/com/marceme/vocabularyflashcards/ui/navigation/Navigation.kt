import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexstyl.swipeablecard.SwipeableCardState
import com.marceme.mvocabulary.ui.theme.model.Word
import com.marceme.mvocabulary.ui.theme.ui.screen.FlashCardScreen
import com.marceme.mvocabulary.ui.theme.ui.navigation.Screen
import com.marceme.mvocabulary.ui.theme.ui.screen.AddCardScreen


@Composable
fun NavigationStack(
    innerPadding: PaddingValues,
    navController: NavHostController,
    states: List<Pair<Word, SwipeableCardState>>,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.FlashCard.route,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        composable(route = Screen.FlashCard.route) {
            FlashCardScreen(states =states)
        }
        composable(route = Screen.AddWord.route) {
            AddCardScreen()
        }
    }

}