package ni.edu.uca.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityPantallaDeEjerciciosBinding

class Pantalla_de_Ejercicios : AppCompatActivity() {
    private lateinit var  binding: ActivityPantallaDeEjerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPantallaDeEjerciciosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnVolver.setOnClickListener{
            startActivity(Intent(this,menu_ninos::class.java))
        }

        binding.btnContinuar.setOnClickListener{
            startActivity(Intent(this,Ejercicio_Final::class.java))
        }
    }
}