package com.marceme.mvocabulary.ui.theme.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import com.marceme.mvocabulary.ui.theme.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardAppBar(
    onAddIconClicked: () -> Unit,
    onRepeatIconClicked: () -> Unit,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            if(canNavigateBack) {
                Text("Flash")
            }else{
                Text("Create Word")
            } },
        actions = {
            if(canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Add")
                }
            }else {
                IconButton(onClick = onAddIconClicked) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
                IconButton(onClick = onRepeatIconClicked) {
                    Icon(imageVector = Icons.Filled.Repeat, contentDescription = "Shuffle")
                }
            }
        })
}