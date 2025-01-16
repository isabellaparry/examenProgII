package com.example.examenprogll.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.examenprogll.viewmodel.RegistroMedidorViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FormularioMedicion(viewModel: RegistroMedidorViewModel, onNavigateBack: () -> Unit) {
    var tipo by remember { mutableStateOf("Agua") }
    var valor by remember { mutableStateOf("") }
    val fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    Column {
        // Selector de tipo
        Row {
            RadioButton(selected = tipo == "Agua", onClick = { tipo = "Agua" })
            Text("Agua")
            RadioButton(selected = tipo == "Luz", onClick = { tipo = "Luz" })
            Text("Luz")
            RadioButton(selected = tipo == "Gas", onClick = { tipo = "Gas" })
            Text("Gas")
        }

        // Campo para ingresar valor
        OutlinedTextField(
            value = valor,
            onValueChange = { valor = it },
            label = { Text("Valor del Medidor") }
        )

        // Botón para guardar
        Button(onClick = {
            if (valor.isNotEmpty()) {
                viewModel.agregarRegistro(tipo, valor.toDouble(), fecha)
                onNavigateBack()
            }
        }) {
            Text("Registrar")
        }
    }
}