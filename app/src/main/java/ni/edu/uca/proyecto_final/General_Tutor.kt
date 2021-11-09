package ni.edu.uca.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.proyecto_final.databinding.ActivityGeneralTutorBinding

class General_Tutor : AppCompatActivity() {
    private lateinit var binding:ActivityGeneralTutorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGeneralTutorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }
        binding.button7.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }
        binding.button6.setOnClickListener {
            startActivity(Intent(this,Detalles_Tutor::class.java))
        }

    }
}