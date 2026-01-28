package com.example.myapplication

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.theme.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculadoraViewModel : ViewModel() {

    // El estado inicial (blanco)
    private val _uiState = MutableStateFlow(UiState(color = Color.White.toArgb()))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    // Cambiar el color
    fun actualizarColor(nuevoColorArgb: Int) {
        _uiState.update { estadoActual ->
            estadoActual.copy(color = nuevoColorArgb)
        }
    }
}