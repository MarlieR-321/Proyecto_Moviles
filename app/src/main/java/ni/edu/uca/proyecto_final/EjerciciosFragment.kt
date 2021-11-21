package ni.edu.uca.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.databinding.FragmentEjerciciosBinding
import pl.droidsonroids.gif.GifImageView


class EjerciciosFragment : Fragment() {
    private lateinit var binding:FragmentEjerciciosBinding
    var num = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEjerciciosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinuar.setOnClickListener {

           // guardarDatos()

            cambiarDatos()

        }

        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.menuNinosFragment)
        }
    }

    private fun guardarDatos() {
        TODO("Not yet implemented")
    }

    private fun cambiarDatos() {
        when(num){
            1 -> {
                binding.gifcalen.setImageResource(R.drawable.brazos2)
                binding.tvEjercicios.setText("Brazos en horizontal")
                binding.tvTempoRep.setText("15 repeticiones")
                num=num+1
                }
            2 -> {
                binding.gifcalen.setImageResource(R.drawable.calentamiento1)
                binding.tvEjercicios.setText("Salto estrella")
                binding.tvTempoRep.setText("10 repeticiones")
                num=num+1
                }
            3 -> {
                binding.gifcalen.setImageResource(R.drawable.calenetamien2)
                binding.tvEjercicios.setText("Unsplash")
                binding.tvTempoRep.setText("15 repeticiones")
                num=num+1
                }
            4 -> { findNavController().navigate(R.id.ejerciciosFinalFragment) }
        }
    }
}


