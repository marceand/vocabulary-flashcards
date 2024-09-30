package com.marceme.mvocabulary.ui.theme.ui.navigation

sealed class Screen(val route: String){
    object FlashCard: Screen ("flash_card")
    object AddWord: Screen ("add_word")
}