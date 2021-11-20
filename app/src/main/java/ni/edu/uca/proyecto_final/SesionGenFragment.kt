package ni.edu.uca.proyecto_final

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.adapters.SesionAdapter
import ni.edu.uca.proyecto_final.data.bd.DbSesion
import ni.edu.uca.proyecto_final.databinding.FragmentSesionGenBinding

class SesionGenFragment : Fragment() {
    private lateinit var binding: FragmentSesionGenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSesionGenBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        binding.rvListaSesion.layoutManager
        var dbsesion:DbSesion = context?.let { DbSesion(it) }!!

        //Todo esto es intento de cargar una lista, no crashea pero no esta probado
        val adapter = SesionAdapter(dbsesion.mostrarSesion())

        binding.rvListaSesion.adapter = adapter
    }

}