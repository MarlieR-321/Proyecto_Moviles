package ni.edu.uca.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        binding.btnAbout.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }
    }
}