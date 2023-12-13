package com.example.mascotasapp

import android.os.Bundle
import com.example.mascotasapp.Database.MascotasApp
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class DeleteActivity : ActivityWithMenu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Borrar las mascotas
        binding.btonEliminar.setOnClickListener{
            var mascotaseliminar = binding.escribePropietario.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                var lista_Mascotas = MascotasApp.database.MascotasDao().getMascotas(mascotaseliminar)

                for (i in 0 until lista_Mascotas.mascota.size) {
                    MascotasApp.database.MascotasDao().deleteMascota(lista_Mascotas.mascota[i])
                }
                var borrar = binding.escribePropietario.text.toString()

                MascotasApp.database.MascotasDao().deleteMascota(borrar)
            }
            runOnUiThread { true }

        }
    }
}
