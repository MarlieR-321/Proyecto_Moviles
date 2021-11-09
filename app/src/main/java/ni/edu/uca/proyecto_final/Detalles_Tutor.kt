package ni.edu.uca.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityDetallesTutorBinding
import ni.edu.uca.proyecto_final.databinding.ActivityEjercicioFinalBinding

class Detalles_Tutor : AppCompatActivity() {
    private lateinit var binding:ActivityDetallesTutorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetallesTutorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnGeneral.setOnClickListener {
            // TODO() Sentencia para ir a general que todavia no existe
            startActivity(Intent(this, General_Tutor::class.java))
        }

    }


}