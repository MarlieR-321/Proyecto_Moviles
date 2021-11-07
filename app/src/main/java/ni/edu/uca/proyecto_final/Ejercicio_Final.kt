package ni.edu.uca.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityEjercicioFinalBinding
import ni.edu.uca.proyecto_final.databinding.ActivityMainBinding

class Ejercicio_Final : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicioFinalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEjercicioFinalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegresar.setOnClickListener {
            startActivity(Intent(this,menu_ninos::class.java))
        }
    }
}