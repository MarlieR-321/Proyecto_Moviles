package ni.edu.uca.proyecto_final

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.bd.DbSesion
import ni.edu.uca.proyecto_final.data.entidades.Usuario
import ni.edu.uca.proyecto_final.databinding.FragmentMenuNinosBinding


class MenuNinosFragment : Fragment() {
    private lateinit var binding:FragmentMenuNinosBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuNinosBinding.inflate(inflater,container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvNombreUsuario.text = "Hiii ${Usuario.nombre_real}"
        var dbSesion: DbSesion = context?.let { DbSesion(it) }!!

        binding.btnCalentamiento.setOnClickListener {
            dbSesion.nuevaSesion()
            findNavController().navigate(R.id.ejerciciosFragment)
        }
        binding.btnPiernas.setOnClickListener {
            dbSesion.nuevaSesion()
            findNavController().navigate(R.id.ejercicio2Fragment)
        }
        binding.btnCardio.setOnClickListener {
            dbSesion.nuevaSesion()
            findNavController().navigate(R.id.ejercicio3Fragment)
        }
        binding.btnAerobicos.setOnClickListener {
            dbSesion.nuevaSesion()
            findNavController().navigate(R.id.ejercicio4Fragment)
        }
        binding.btnYoga.setOnClickListener {
            dbSesion.nuevaSesion()
            findNavController().navigate(R.id.ejercicio5Fragment)
        }
        binding.btnSalir.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

    }
}