package com.marceme.vocabularyflashcards.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marceme.mvocabulary.ui.theme.model.Word

@Composable
fun WordCard(modifier: Modifier, word: Word) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(20.dp)
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