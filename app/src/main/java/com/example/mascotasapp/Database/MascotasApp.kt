package com.example.mascotasapp.Database

import android.app.Application
import androidx.room.Room

class MascotasApp: Application() {
    companion object {
        lateinit var database: DBPropietarios
    }

    override fun onCreate() {
        super.onCreate()
        MascotasApp.database = Room.databaseBuilder(this,DBPropietarios::class.java, "DBPropietarios").build()
    }
}