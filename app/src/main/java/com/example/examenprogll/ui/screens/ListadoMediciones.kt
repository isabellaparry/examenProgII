package com.example.examenprogll.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.registromedidores.viewmodel.RegistroMedidorViewModel

@Composable
fun ListadoMediciones(viewModel: RegistroMedidorViewModel, onNavigateToFormulario: () -> Unit) {
    val registros by viewModel.registros.observeAsState(emptyList())

    LazyColumn {
        items(registros) { registro ->
            Text(text = "${registro.tipo}: ${registro.valor} (${registro.fecha})")
        }
    }

    FloatingActionButton(onClick = onNavigateToFormulario) {
        Icon(Icons.Default.Add, contentDescription = "Agregar")
    }
}