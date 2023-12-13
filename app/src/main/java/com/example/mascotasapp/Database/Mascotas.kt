package com.example.mascotasapp.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Mascotas")
data class Mascotas(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nombre: String = "",
    var esPerro: Boolean,
    var raza: String="",
    var fecha_nacimiento: String ="",
    var duenio: String=""
)
