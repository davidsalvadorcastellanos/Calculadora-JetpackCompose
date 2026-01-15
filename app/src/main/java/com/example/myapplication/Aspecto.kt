package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.UiState
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

val uiState: StateFlow<UiState> = MutableStateFlow(UiState())

@Composable
fun Aspecto(
    modifier: Modifier = Modifier
){

    val controller = rememberColorPickerController()
    val estado by uiState.collectAsState()

    HsvColorPicker(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        controller = controller,
        onColorChanged = { envelope ->
            (uiState as MutableStateFlow).value =
                estado.copy(color = envelope.color.toArgb())
        }
    )

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
            selected = false,
            onClick = { (uiState as MutableStateFlow).value = estado.copy(showTopBar = !estado.showTopBar)}
        )
            Text("Ocultar barra superior.") }


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = false,
                onClick = { (uiState as MutableStateFlow).value = estado.copy(showBottonBar = !estado.showBottonBar)}
            )
            Text("Ocultar barra inferior.")
        }

    }
}