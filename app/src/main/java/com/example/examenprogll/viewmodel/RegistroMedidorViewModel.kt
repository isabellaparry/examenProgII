package com.example.examenprogll.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.room.Room
import com.example.examenprogll.data.AppDatabase
import com.example.examenprogll.data.RegistroMedidor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RegistroMedidorViewModel(application: Application) : AndroidViewModel(application) {
    private val database = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "medidores_db"
    ).build()

    private val dao = database.registroMedidorDao()

    val registros: LiveData<List<RegistroMedidor>> = dao.getRegistros().asLiveData()

    fun agregarRegistro(tipo: String, valor: Double, fecha: String) {
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            dao.insertRegistro(RegistroMedidor(tipo = tipo, valor = valor, fecha = fecha))
        }
    }
}
