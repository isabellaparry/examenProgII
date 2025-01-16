package com.example.registromedidores.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registromedidores.ui.screens.ListadoMediciones
import com.example.registromedidores.ui.screens.FormularioMedicion

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "listado") {
        composable("listado") {
            ListadoMediciones(
                onNavigateToFormulario = { navController.navigate("formulario") }
            )
        }
        composable("formulario") {
            FormularioMedicion(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}