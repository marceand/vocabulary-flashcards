package com.marceme.vocabularyflashcards.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.marceme.vocabularyflashcards.ui.theme.ToolbarColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardScreen(modifier: Modifier = Modifier, navigateUp: () -> Unit){
    var selectedValue by rememberSaveable { mutableStateOf("") }
    val categories = listOf("Adjective", "Noun", "Verb", "Adverb")

        Column (modifier = Modifier.fillMaxWidth()) {
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
            Text(text = "Word", color= Color.Black, fontSize = 24.sp )
            OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = "", onValueChange = {}, placeholder = {Text(
                text = "e.g.delicious")}
            )
            Text(text = "Description", color= Color.Black, fontSize = 24.sp )
            OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = "", onValueChange = {}, placeholder = {Text(
                text = "e.g.hook")}
            )
            Text(text = "Choose a category", color= Color.Black, fontSize = 24.sp )

            categories.forEach {
                category -> Row  (verticalAlignment = Alignment.CenterVertically){
                RadioButton(selected = selectedValue == category, onClick = {
                    selectedValue  =  category
                })
                Text(text = category)
            }
            }
            Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
                Text(text = "Save")
            }
        }

}


@Preview(widthDp = 412, heightDp = 915)
@Composable
fun AddWordScreenPreview() {
    AddCardScreen(navigateUp = {})
}