package com.example.mascotasapp.Database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction


interface MascotasDao {
    //Mostar los mascotas
    @Transaction
    @Query("SELECT * FROM mascotas WHERE duenio = :propietarios")
    fun getMascotas(propietarios: String): MutableList<Mascotas>


    //Insertar los mascotas
    @Insert
    fun addMascotas(mascotas: Mascotas)

    //Eliminar mascota
    @Delete
    fun deleteMascota(mascota: String)



}