package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import com.example.mascotasapp.Database.Mascotas
import com.example.mascotasapp.Database.MascotasApp
import com.example.mascotasapp.Database.Propietarios
import com.example.mascotasapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener{
            //Creamos un objeto Propietarios y llamamos al método para insertarlo en la BBDD
            addPropietarios(Propietarios(nombre_propietario = binding.nombrePropietario.text.toString(), direcion_propietario = binding.direccionPropietario.text.toString(), til_propietario = binding.telefonoPropietario.text.toString()))

            //Crearemos un ojeto Mascotas y llamamos al método para insertarlo en la BBDD
            addMascotas(Mascotas(nombre = binding.nombreMascota.text.toString(),esPerro = binding.grupoRadio.isActivated, raza = binding.razaMascota.text.toString(), fecha_nacimiento = binding.fechaNacMascota.text.toString(), duenio = binding.nombrePropietario.text.toString()))

            //Limpiar mascotas
            binding.nombreMascota.text.clear()
            binding.razaMascota.text.clear()
            binding.fechaNacMascota.text.clear()


        }
        //insertar otra mascota
        binding.btnOtraMascota.setOnClickListener{
            addMascotas(Mascotas(nombre = binding.nombreMascota.text.toString(), esPerro = binding.grupoRadio.isActivated , raza = binding.razaMascota.text.toString(), fecha_nacimiento = binding.fechaNacMascota.text.toString(), duenio = binding.nombrePropietario.text.toString()))

        }
    }
    fun addPropietarios(propietarios: Propietarios) {
        //Accedemos a la BBDD en segundo plano usando corrutinas
        CoroutineScope(Dispatchers.IO).launch {
            MascotasApp.database.PropietariosDao().addPropietario(propietarios)

        }
    }
    fun addMascotas(mascotas: Mascotas) {
        //Accedemos a la BBDD en segundo plano usando corrutinas
        CoroutineScope(Dispatchers.IO).launch {
            MascotasApp.database.MascotasDao().addMascotas(mascotas)

        }
    }

}