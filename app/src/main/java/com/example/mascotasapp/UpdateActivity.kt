package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.Database.MascotasApp
import com.example.mascotasapp.Database.Propietarios
import com.example.mascotasapp.databinding.ActivityMainBinding
import com.example.mascotasapp.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UpdateActivity : ActivityWithMenu() {
    lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActualizar.setOnClickListener{
            actualizardireccion(Propietarios(nombre_propietario = binding.nPropietario.text.toString(), direcion_propietario = binding.nuevaDireccion.text.toString()))
        }
    }
    fun actualizardireccion(propietarios: Propietarios) {
        CoroutineScope(Dispatchers.IO).launch {
            //la variable n contiene el nombre del propietarios introducido en el formulario
            val n = propietarios.nombre_propietario

            //recoveryPropietario es el registro de la tabla que contiene el nombre introducido en el formulario:
            val recoveryPropietario = MascotasApp.database.PropietariosDao().getPropietarios()

            //Asignamos la nueva direccion introducido para cambiarlo en el registro del propietario:
            recoveryPropietario.nuevaDireccion =binding.nuevaDireccion.text.toString()
            //Actualizamos el registro en la BBDD:
            MascotasApp.database.PropietariosDao().actualizarDireccion(recoveryPropietario)
        }
    }
}