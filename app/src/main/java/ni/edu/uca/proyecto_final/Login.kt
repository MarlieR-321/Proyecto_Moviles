package ni.edu.uca.proyecto_final

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ni.edu.uca.proyecto_final.databinding.ActivityLoginBinding

class Login: AppCompatActivity(){
    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btIniciarLogin.setOnClickListener {
            /*
            * if(/*ver que rol tiene la cuenta y es niño*/){
            *   verVistaMenuninos()
            * }else if(/*ver rol que tiene la cuenta y es adulto*/){
            *   verVistaTutor()
            * }*/
        }
    }

    private fun verVistaMenuninos() {
        startActivity(Intent(this,menu_ninos::class.java))
    }
/*
    private fun verVistaTutor() {
        startActivity(Intent(this,/*menu_tutor*/::class.java))
    }

*/
}