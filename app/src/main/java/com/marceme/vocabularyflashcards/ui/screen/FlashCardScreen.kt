package com.marceme.vocabularyflashcards.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.SwipeableCardState
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.marceme.mvocabulary.ui.theme.model.Word
import com.marceme.mvocabulary.ui.theme.model.words
import com.marceme.vocabularyflashcards.ui.components.ProgressBar
import com.marceme.vocabularyflashcards.ui.components.WordCard
import com.marceme.vocabularyflashcards.ui.theme.ActiveTrackColor
import com.marceme.vocabularyflashcards.ui.theme.BackgroundColor
import com.marceme.vocabularyflashcards.ui.theme.InactiveTrackColor
import com.marceme.vocabularyflashcards.ui.theme.ToolbarColor


@Composable
fun FlashCardScreen(modifier: Modifier = Modifier, states: List<Pair<Word, SwipeableCardState>>) {
    Column(modifier = modifier) {
        FlashCardsTopBar()
        FlashCardsContent(states)
    }
}

@Composable
private fun FlashCardsContent(states: List<Pair<Word, SwipeableCardState>>) {
    Column(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        ProgressIndicator(
            Modifier.padding(
                bottom = 16.dp,
                start = 44.dp,
                end = 44.dp
            )
        )
        FlashCards(
            Modifier
                .padding(44.dp)
                .aspectRatio(0.8f), states
        )

    }
}

@Composable
private fun ProgressIndicator(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.End)
                .padding(bottom = 4.dp),
            text = "15/250",
            color = Color.DarkGray,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        ProgressBar(
            value = 0.5f,
            trackHeight = 10.dp,
            activeColor = ActiveTrackColor,
            inactiveColor = InactiveTrackColor
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FlashCardsTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ToolbarColor,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        title = { Text("Flashcards", fontWeight = FontWeight.Medium) },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Repeat, contentDescription = "Shuffle")
            }
        })
}

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
private fun FlashCards(
    modifier: Modifier = Modifier,
    states: List<Pair<Word, SwipeableCardState>>
) {
    Box(modifier) {
        states.forEach { (word, state) ->
            if (state.swipedDirection == null) {
                WordCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(
                                Direction.Down,
                                Direction.Up,
                                Direction.Right
                            ),
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
        }
    }
}

@Preview(widthDp = 412, heightDp = 915)
@Composable
fun FlashCardScreenPreview() {
    val states = words.reversed()
        .map { it to rememberSwipeableCardState() }
    FlashCardScreen(states = states)
}



