package ni.edu.uca.proyecto_final

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ni.edu.uca.proyecto_final.databinding.ActivityLoginBinding
import ni.edu.uca.proyecto_final.databinding.ActivityMainBinding

class Login: AppCompatActivity(){
    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(/*Usar un binding que lea la cuenta del usuario y en bd leer su rol. Si el rol es niño sera*/){
            binding.btIniciarLogin.setOnClickListener {
                verVistaMenuninos()
            }
        }
        if(/*Si el rol delusuario es tutor*/){
            binding.btIniciarLogin.setOnClickListener {
                verVistaTutor()
            }
        }
    }

    private fun verVistaMenuninos() {
        startActivity(Intent(this,menu_ninos::class.java))
    }

    private fun verVistaTutor() {
        startActivity(Intent(this,/*menu_tutor*/::class.java))
    }
}