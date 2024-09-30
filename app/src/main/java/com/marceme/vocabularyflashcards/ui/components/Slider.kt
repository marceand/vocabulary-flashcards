package com.marceme.mvocabulary.ui.theme.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WordSlider(modifier: Modifier = Modifier) {
    val sliderValue = remember {
        mutableStateOf(0f)
    }

    Column {
        Text(text = "Value: ${sliderValue.value}")
        Slider(
            modifier = Modifier.fillMaxWidth(),
            value = sliderValue.value,
            onValueChange = { sliderValue.value = it },
            valueRange = 0f..100f)
    }
}

@Preview(widthDp = 412, heightDp = 915)
@Composable
fun WordSliderPreview() {
    WordSlider()
}