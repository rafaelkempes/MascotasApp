package com.example.mascotasapp.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [Propietarios::class, Mascotas::class],
version = 1)
abstract class DBPropietarios:RoomDatabase() {
    abstract fun PropietariosDao(): PropietariosDao
    abstract fun MascotasDao(): MascotasDao
}