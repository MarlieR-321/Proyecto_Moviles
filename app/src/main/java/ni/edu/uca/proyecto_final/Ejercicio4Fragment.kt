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
import ni.edu.uca.proyecto_final.databinding.FragmentEjercicio4Binding



class Ejercicio4Fragment : Fragment() {
    private lateinit var binding:FragmentEjercicio4Binding
    var num = 0
    val idCateg = 4

    /*@RequiresApi(Build.VERSION_CODES.P)
    var dbejercicios: DbEjercicios = context?.let { DbEjercicios(it) }!!
    @RequiresApi(Build.VERSION_CODES.P)
    var listaEjercicios = dbejercicios.mostrarEjercicios(idCateg)*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEjercicio4Binding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.tvEjercicios.text = listaEjercicios[13].nombre_ejercicio
        //binding.tvTempoRep.text = listaEjercicios[13].repeticion

        binding.btnContinuar.setOnClickListener {


            cambiarDatos()
        }

        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.menuNinosFragment)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun cambiarDatos() {
        var dbejercicios: DbEjercicios = context?.let { DbEjercicios(it) }!!
        var listaEjercicios = dbejercicios.mostrarEjercicios(idCateg)

        when(num){
            0 -> {
                binding.gifcalen.setImageResource(R.drawable.abrazo_rodilla)
                binding.tvEjercicios.text = listaEjercicios[0].nombre_ejercicio
                binding.textView.setText("Haz")
                binding.tvTempoRep.text = listaEjercicios[0].repeticion
                binding.btnContinuar.setText("Continuar ejercitandote!")
                num += 1
            }
            1 -> {
                binding.gifcalen.setImageResource(R.drawable.frog_crunch)
                binding.tvEjercicios.text = listaEjercicios[1].nombre_ejercicio
                binding.tvTempoRep.text = listaEjercicios[1].repeticion
                num += 1
            }
            2 -> {
                binding.gifcalen.setImageResource(R.drawable.impulso)
                binding.tvEjercicios.text = listaEjercicios[2].nombre_ejercicio
                binding.tvTempoRep.text = listaEjercicios[2].repeticion
                num += 1
            }
            3 -> {
                binding.gifcalen.setImageResource(R.drawable.escalador_monta_a)
                binding.tvEjercicios.text = listaEjercicios[3].nombre_ejercicio
                binding.tvTempoRep.text = listaEjercicios[3].repeticion
                num += 1
            }
            4 -> { findNavController().navigate(R.id.ejerciciosFinalFragment) }
        }
    }
}