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
            startActivity(Intent(this,Login::class.java))
        }
        binding.btnCalentamiento.setOnClickListener{
            startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
        }
        binding.btnPiernas.setOnClickListener{
            startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
        }
        binding.btnCardio.setOnClickListener{
            startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
        }
        binding.btnAerobicos.setOnClickListener{
            startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
        }
        binding.btnYoga.setOnClickListener{
            startActivity(Intent(this,Pantalla_de_Ejercicios::class.java))
        }
    }
}