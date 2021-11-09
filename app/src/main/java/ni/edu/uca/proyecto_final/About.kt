package ni.edu.uca.proyecto_final

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ni.edu.uca.proyecto_final.databinding.ActivityAboutBinding

class About : AppCompatActivity() {
    private lateinit var  binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}