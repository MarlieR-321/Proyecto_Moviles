package ni.edu.uca.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityMenuNinosBinding

class menu_ninos : AppCompatActivity() {
    private lateinit var  binding: ActivityMenuNinosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuNinosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSalir.setOnClickListener{
            volverLogin()
        }
        binding.btnCalentamiento.setOnClickListener{
            ejerCalentamiento()
        }
        binding.btnPiernas.setOnClickListener{
            ejerPiernas()
        }
        binding.btnCardio.setOnClickListener{
            ejerCardio()
        }
        binding.btnAerobicos.setOnClickListener{
            ejerAerobicos()
        }
        binding.btnYoga.setOnClickListener{
            ejerYoga()
        }
    }

    private fun volverLogin() {
        startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
    }

    private fun ejerCalentamiento() {
        startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
    }

    private fun ejerPiernas(){
        startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
    }

    private fun ejerCardio() {
        startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
    }

    private fun ejerAerobicos(){
        startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
    }

    private fun ejerYoga() {
        startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
    }
}