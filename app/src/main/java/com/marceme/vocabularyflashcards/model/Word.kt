package com.marceme.mvocabulary.ui.theme.model

data class Word(
    val id: Int,
    val word: String,
    val definition: String,
    val category: String,
    val date: String
)

val words = listOf(
    Word(1, "Splendid", "", "Noun", "09/08/24"),
    Word(2, "Relevant", "", "Noun", "09/08/24"),
    Word(3, "Abandon", "", "Noun", "09/08/24")
)
