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
import ni.edu.uca.proyecto_final.data.bd.DbSesion
import ni.edu.uca.proyecto_final.data.bd.DbSesionDet
import ni.edu.uca.proyecto_final.databinding.FragmentEjercicio5Binding



class Ejercicio5Fragment : Fragment() {
    private lateinit var binding:FragmentEjercicio5Binding
    var num = 0
    val idCateg = 5

    /*RequiresApi(Build.VERSION_CODES.P)
    var dbejercicios: DbEjercicios = context?.let { DbEjercicios(it) }!!
    @RequiresApi(Build.VERSION_CODES.P)
    var listaEjercicios = dbejercicios.mostrarEjercicios(idCateg)*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEjercicio5Binding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.tvEjercicios.text = listaEjercicios[0].nombre_ejercicio
        //binding.tvTempoRep.text = listaEjercicios[0].repeticion

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
                binding.gifcalen.setImageResource(R.drawable.yoga_1)
                binding.tvEjercicios.text = listaEjercicios[0].nombre_ejercicio
                binding.textView.setText("Haz")
                binding.tvTempoRep.text = listaEjercicios[0].repeticion
                binding.btnContinuar.setText("Continuar ejercitandote!")
                guardar(listaEjercicios[0].id_ejercicio)
                num += 1
            }
            1 -> {
                binding.gifcalen.setImageResource(R.drawable.yoga_2)
                binding.tvEjercicios.text = listaEjercicios[1].nombre_ejercicio
                binding.tvTempoRep.text = listaEjercicios[1].repeticion
                guardar(listaEjercicios[1].id_ejercicio)
                num += 1
            }
            2 -> {
                binding.gifcalen.setImageResource(R.drawable.yoga_3)
                binding.tvEjercicios.text = listaEjercicios[2].nombre_ejercicio
                binding.tvTempoRep.text = listaEjercicios[2].repeticion
                guardar(listaEjercicios[2].id_ejercicio)
                num += 1
            }
            3 -> {
                binding.gifcalen.setImageResource(R.drawable.yoga_4)
                binding.tvEjercicios.text = listaEjercicios[3].nombre_ejercicio
                binding.tvTempoRep.text = listaEjercicios[3].repeticion
                guardar(listaEjercicios[3].id_ejercicio)
                num += 1
            }
            4 -> { findNavController().navigate(R.id.ejerciciosFinalFragment) }
        }
    }
    @RequiresApi(Build.VERSION_CODES.P)
    fun guardar(Id_ejercicio:Int){
        var dbSesion: DbSesion = context?.let { DbSesion(it) }!!
        var Id = dbSesion.getId()

        var dbSesionDet: DbSesionDet = context?.let { DbSesionDet(it) }!!
        dbSesionDet.InsertarDetalle(Id, Id_ejercicio)
    }
}