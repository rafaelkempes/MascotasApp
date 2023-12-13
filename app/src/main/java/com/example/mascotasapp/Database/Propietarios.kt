package com.example.mascotasapp.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "propietarios")
data class Propietarios (
    @PrimaryKey
    var nombre_propietario: String = "",
    var direcion_propietario: String="",
    var til_propietario: String=""
)
