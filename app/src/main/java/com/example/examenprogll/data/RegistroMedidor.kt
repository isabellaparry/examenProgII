package com.example.examenprogll.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registro_medidor")
data class RegistroMedidor(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipo: String,
    val valor: Double,
    val fecha: String
)
