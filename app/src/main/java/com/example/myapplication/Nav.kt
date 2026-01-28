package com.example.myapplication

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.compose.ui.graphics.toArgb
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navegador(navController: NavHostController = rememberNavController(),
              viewModel: CalculadoraViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val estado by viewModel.uiState.collectAsState()


    val colorAnimado by animateColorAsState(
        targetValue = Color(estado.color),
        label = "Color de fondo animado",
        animationSpec = tween(durationMillis = 1000) // 1 segundo de transición
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colorAnimado
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 5.dp)
                ) {
                    NavigationDrawerItem(
                        label = { Text("Presentación") },
                        selected = false,
                        onClick = {
                            viewModel.actualizarColor(Color.Magenta.toArgb())
                            navController.navigate(Pantallas.Calculadora.name)
                            scope.launch { drawerState.close() }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Calculadora") },
                        selected = false,
                        onClick = {
                            viewModel.actualizarColor(Color.Green.toArgb())
                            navController.navigate(Pantallas.Calculadora.name)
                            scope.launch { drawerState.close() }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Resultado") },
                        selected = false,
                        onClick = {
                            viewModel.actualizarColor(Color.DarkGray.toArgb())
                            navController.navigate(Pantallas.Resultado.name)
                            scope.launch { drawerState.close() }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Aspecto") },
                        selected = false,
                        onClick = {
                            viewModel.actualizarColor(Color.Cyan.toArgb())
                            navController.navigate(Pantallas.Aspecto.name)
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold (
            topBar = {
                if(uiState.collectAsState().value.showTopBar){
                    CenterAlignedTopAppBar(
                        title = { Text("Calculadora") },
                        navigationIcon = {
                            IconButton(onClick = {  }) {
                                Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Atras")
                            }
                        }
                    )
                }
            },

            bottomBar = {
                if(uiState.collectAsState().value.showBottonBar){
                    BottomAppBar(
                        actions = {
                            Row {
                                IconButton(onClick = {  },
                                    modifier = Modifier.weight(1f)) {
                                    Icon(Icons.Filled.Check, contentDescription = "Localized description")
                                }
                                FloatingActionButton(
                                    onClick = {  },
                                ) {
                                    Icon(Icons.Filled.Add, "Localized description")
                                }
                                IconButton(onClick = {  },
                                    modifier = Modifier.weight(1f)) {
                                    Icon(Icons.Filled.AcUnit, contentDescription = "Localized description")
                                }
                            }
                        }
                    )
                }
            },
            containerColor = colorAnimado
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Pantallas.Presentacion.name,
                modifier = Modifier.padding(innerPadding)
            ){
                composable(Pantallas.Presentacion.name){
                    Presentacion()
                }

                composable(Pantallas.Calculadora.name){
                    Calculadora()
                }

                composable(Pantallas.Resultado.name){
                    Resultado()
                }

                composable(Pantallas.Aspecto.name){
                    Aspecto()
                }
            }
        }
    }
}
