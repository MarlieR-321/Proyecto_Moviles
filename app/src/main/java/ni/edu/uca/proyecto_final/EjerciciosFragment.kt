package ni.edu.uca.proyecto_final

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.bd.DbEjercicios
import ni.edu.uca.proyecto_final.data.bd.DbUsuario
import ni.edu.uca.proyecto_final.databinding.FragmentEjerciciosBinding
import pl.droidsonroids.gif.GifImageView


class EjerciciosFragment : Fragment() {
    private lateinit var binding:FragmentEjerciciosBinding
    var num = 1
    val idCateg = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEjerciciosBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinuar.setOnClickListener {

            //var dbejercicios: DbEjercicios = context?.let { DbEjercicios(it) }!!
            //var usuario = dbejercicios.mostrarEjercicios(idCateg)
           // guardarDatos()
            cambiarDatos()
        }

        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.menuNinosFragment)
        }
    }

    private fun cambiarDatos() {
        when(num){
            1 -> {
                binding.gifcalen.setImageResource(R.drawable.brazos2)
                binding.tvEjercicios.text = "Brazos en horizontal"
                binding.tvTempoRep.text = "15 repeticiones"
                num += 1
                }
            2 -> {
                binding.gifcalen.setImageResource(R.drawable.calentamiento1)
                binding.tvEjercicios.text = "Salto estrella"
                binding.tvTempoRep.text = "10 repeticiones"
                num += 1
                }
            3 -> {
                binding.gifcalen.setImageResource(R.drawable.calenetamien2)
                binding.tvEjercicios.text = "Unsplash"
                binding.tvTempoRep.text = "15 repeticiones"
                num += 1
                }
            4 -> { findNavController().navigate(R.id.ejerciciosFinalFragment) }
        }
    }
}


