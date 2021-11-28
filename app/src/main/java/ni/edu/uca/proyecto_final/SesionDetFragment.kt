package ni.edu.uca.proyecto_final

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.proyecto_final.data.adapters.SesionDetAdapter
import ni.edu.uca.proyecto_final.data.bd.DbSesionDet
import ni.edu.uca.proyecto_final.data.entidades.SesionObj
import ni.edu.uca.proyecto_final.databinding.FragmentSesionDetBinding


class SesionDetFragment : Fragment() {
    private lateinit var binding: FragmentSesionDetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSesionDetBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.sesionGenFragment)
        }

        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        var dbSesion:DbSesionDet=context?.let { DbSesionDet(it) }!!
        val Adapter= SesionDetAdapter(dbSesion.MostrarDetalle(SesionObj.Id_Sesion))
        binding.recyclerView.adapter=Adapter
    }
}