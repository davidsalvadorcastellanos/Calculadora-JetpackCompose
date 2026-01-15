package com.example.myapplication.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

data class UiState(
    var resultado: Int = 0,
    var color: Int = Color.White.toArgb(),
    var showTopBar: Boolean = true,
    var showBottonBar: Boolean = true
)
