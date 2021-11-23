package ni.edu.uca.proyecto_final

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.bd.DbUsuario
import ni.edu.uca.proyecto_final.databinding.FragmentCrearCuentaBinding

class CrearCuentaFragment : Fragment() {
    lateinit var binding: FragmentCrearCuentaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCrearCuentaBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var camp1 = binding.etNombreReal
        var camp2 = binding.etUsuario
        var camp3 = binding.etContraseA
        var camp4 = binding.spinner2
        var camp5 = binding.edtCorreo


        binding.btCrear.setOnClickListener{

            var dbusuario: DbUsuario = context?.let { DbUsuario(it) }!!

            if (camp4.selectedItem.toString()=="Tutor"){
                findNavController().navigate(R.id.homeFragment)
                dbusuario.insertarUsuario(
                    camp1.text.toString(),
                    camp2.text.toString(),
                    camp3.text.toString(),
                    1,camp5.text.toString())
            }else if (camp4.selectedItem.toString()=="Niño") {
                findNavController().navigate(R.id.homeFragment)
                dbusuario.insertarUsuario(
                    camp1.text.toString(),
                    camp2.text.toString(),
                    camp3.text.toString(),
                    2,camp5.text.toString())
            }
        }
    }
}