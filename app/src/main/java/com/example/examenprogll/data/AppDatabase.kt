package com.example.examenprogll.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RegistroMedidor::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun registroMedidorDao(): RegistroMedidorDao
}
