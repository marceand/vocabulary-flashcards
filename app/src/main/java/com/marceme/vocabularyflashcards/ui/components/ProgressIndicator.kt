package com.marceme.vocabularyflashcards.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    value: Float = 0.5f,
    trackHeight: Dp = 10.dp,
    activeColor: Color = Color(0xFF4A90E2),
    inactiveColor: Color = Color.White,
) {

    val coerced = value.coerceIn(0f, 1f)

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(trackHeight)
    ) {
        val width = constraints.maxWidth.toFloat()
        val height = constraints.maxHeight.toFloat()
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Inactive track
            drawRoundRect(
                color = inactiveColor,
                cornerRadius = CornerRadius(x = height / 2, y = height / 2),
                size = this.size
            )

            // Active track
            drawRoundRect(
                color = activeColor,
                cornerRadius = CornerRadius(x = height / 2, y = height / 2),
                size = Size(width * coerced, height)
            )
        }
    }
}

@Preview
@Composable
fun ProgressIndicatorPreview(modifier: Modifier = Modifier) {
    ProgressIndicator(
        modifier = modifier,
        trackHeight = 20.dp,
        value = 0.5f
    )
}