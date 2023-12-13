package com.example.mascotasapp.Database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface PropietariosDao {
    //Mostar los propietarios
    @Query("SELECT * FROM propietarios")
    fun getPropietarios(): MutableList<Propietarios>

    //Insertar los propietarios
    @Insert
    fun addPropietario(propietarios: Propietarios)



    @Update
    fun actualizarDireccion(propietarios: Propietarios)

}