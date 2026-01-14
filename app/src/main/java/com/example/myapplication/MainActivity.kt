package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Gris
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora()
        }
    }
}

@Composable
fun Calculadora(modifier: Modifier = Modifier){

    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0) }

    Column(
        modifier.fillMaxSize()
            .padding(horizontal = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Numero 1") }
        )

        Spacer(modifier.padding(10.dp))

        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Numero 2") }
        )

        Row(
            modifier.padding(vertical = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    val n1 = numero1.toIntOrNull() ?: 0
                    val n2 = numero2.toIntOrNull() ?: 0
                    resultado = n1 + n2
                },
                modifier.padding(horizontal = 20.dp).weight(0.50f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gris,
                    contentColor = Color.Black
                )
            ) {
                Text("Sumar", fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = {
                    val n1 = numero1.toIntOrNull() ?: 0
                    val n2 = numero2.toIntOrNull() ?: 0
                    resultado = n1 - n2
                },
                modifier.padding(horizontal = 20.dp).weight(0.50f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gris,
                    contentColor = Color.Black
                )
            ) {
                Text("Restar", fontWeight = FontWeight.Bold)
            }

        }

        Row(
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    val n1 = numero1.toIntOrNull() ?: 0
                    val n2 = numero2.toIntOrNull() ?: 0
                    resultado = n1 * n2
                },
                modifier.padding(horizontal = 20.dp).weight(0.50f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gris,
                    contentColor = Color.Black
                )
            ) {
                Text("Multi", fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = {
                    val n1 = numero1.toIntOrNull() ?: 0
                    val n2 = numero2.toIntOrNull() ?: 0
                    resultado = n1 / n2
                },
                modifier.padding(horizontal = 20.dp).weight(0.50f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gris,
                    contentColor = Color.Black
                )
            ) {
                Text("División", fontWeight = FontWeight.Bold)
            }

        }
        Text("Resultado: $resultado",
            modifier.padding(vertical = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    Calculadora()
}