package com.marceme.vocabularyflashcards.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marceme.vocabularyflashcards.ui.theme.ButtonActiveColor
import com.marceme.vocabularyflashcards.ui.theme.ScreenBackgroundColor
import com.marceme.vocabularyflashcards.ui.theme.TextFieldFocusedColor
import com.marceme.vocabularyflashcards.ui.theme.ToolbarColor


@Composable
fun AddCardScreen(modifier: Modifier = Modifier, navigateUp: () -> Unit) {
    val categories = listOf("Adjective", "Noun", "Verb", "Adverb")
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackgroundColor)
    ) {
        AddCardTopBar(modifier, navigateUp)
        AddCardContent(modifier, categories)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddCardContent(modifier: Modifier, categories: List<String>) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    var word by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var description by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = "Enter a word", color = Color.Black, fontSize = 18.sp)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.DarkGray,
                focusedIndicatorColor = TextFieldFocusedColor,
                focusedTextColor = Color.Black
            ),
            value = word,
            onValueChange = { word = it },
            singleLine = true,
            placeholder = {
                Text(
                    fontSize = 16.sp,
                    text = "e.g.delicious",
                    color = Color.DarkGray
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("Write a short description")
            }
            withStyle(style = SpanStyle(color = Color.Gray)) {
                append(" (optional)")
            }
        }, fontSize = 18.sp)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.DarkGray,
                focusedIndicatorColor = TextFieldFocusedColor,
                focusedTextColor = Color.Black
            ),
            value = description,
            onValueChange = { description = it },
            maxLines = 4,
            placeholder = {
                Text(
                    modifier = modifier.padding(0.dp),
                    fontSize = 16.sp,
                    text = "e.g.hook",
                    color = Color.DarkGray
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        Text(
            text = "Choose a category",
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        categories.forEach { category ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = selectedValue == category, onClick = {
                    selectedValue = category
                })
                Text(text = category, color = Color.Black, fontSize = 16.sp)
            }
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp),
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonActiveColor,
                disabledContainerColor = Color.LightGray
            ),
            onClick = { /*TODO*/ }) {
            Text(text = "Save", color = Color.White, fontSize = 20.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddCardTopBar(modifier: Modifier, navigateUp: () -> Unit) {
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


@Preview(widthDp = 412, heightDp = 915)
@Composable
fun AddWordScreenPreview() {
    AddCardScreen(navigateUp = {})
}