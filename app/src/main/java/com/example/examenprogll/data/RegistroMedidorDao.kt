package com.example.examenprogll.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RegistroMedidorDao {
    @Query("SELECT * FROM registro_medidor ORDER BY fecha DESC")
    fun getRegistros(): Flow<List<RegistroMedidor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRegistro(registro: RegistroMedidor)
}
