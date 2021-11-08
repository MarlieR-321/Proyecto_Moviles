package ni.edu.uca.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityEjercicioFinalBinding

class Detalles_Tutor : AppCompatActivity() {
    private lateinit var binding:ActivityEjercicioFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEjercicioFinalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnRegresar.setOnClickListener {
            // TODO() Sentencia para ir a general que todavia no existe
        }
    }


}