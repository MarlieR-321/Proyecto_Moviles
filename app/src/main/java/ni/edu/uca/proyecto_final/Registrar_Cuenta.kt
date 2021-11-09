package ni.edu.uca.proyecto_final

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ni.edu.uca.proyecto_final.databinding.ActivityRegistrarBinding

class Registrar_Cuenta: AppCompatActivity() {
    private lateinit var binding:ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btCrear.setOnClickListener {
            //TODO() Crear el usuario con bd
            startActivity(Intent(this,Login::class.java))
        }
    }
}