package com.marceme.mvocabulary.ui.theme.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.SwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.marceme.mvocabulary.ui.theme.model.Word


@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun FlashCardScreen(modifier: Modifier = Modifier, states: List<Pair<Word, SwipeableCardState>>) {
    Box(
        Modifier
            .padding(24.dp)
            .fillMaxSize()
            .aspectRatio(1f)
    ) {
        states.forEach { (word, state) ->
            if (state.swipedDirection == null) {
                WordCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(Direction.Down, Direction.Up, Direction.Right),
                            onSwiped = {
                                // swipes are handled by the LaunchedEffect
                                // so that we track button clicks & swipes
                                // from the same place
                            },
                            onSwipeCancel = {
                                Log.d("Swipeable-Card", "Cancelled swipe")
                                //hint = "You canceled the swipe"
                            }
                        ),
                    word = word
                )
            }

            LaunchedEffect(word, state.swipedDirection) {
                if (state.swipedDirection != null) {
                    //hint = "You swiped ${stringFrom(state.swipedDirection!!)}"
                }
            }
        }


    }
}

@Composable
fun WordCard(modifier: Modifier, word: Word) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = word.word,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = word.category,
                fontSize = 14.sp
            )
        }
    }


}

@Preview(widthDp = 412, heightDp = 915)
@Composable
fun WordCardPreview() {
    val word = Word(1, "Splendid", "", "Adjective", "06/10/24")
    WordCard(modifier = Modifier, word = word)
}


