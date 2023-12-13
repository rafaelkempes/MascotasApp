package com.example.mascotasapp.Database

import androidx.room.Embedded
import androidx.room.Relation

data class PropietariosMascotas(
    @Embedded val Propietarios :Propietarios,
    @Relation(
        parentColumn = "nombre_Propietario",
        entityColumn = "duenio"
    )
    val Mascotas:MutableList<Mascotas>
)