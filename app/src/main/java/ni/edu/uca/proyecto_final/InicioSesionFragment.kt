package ni.edu.uca.proyecto_final

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.bd.DbUsuario
import ni.edu.uca.proyecto_final.databinding.FragmentInicioSesionBinding

class InicioSesionFragment : Fragment() {
    private lateinit var binding: FragmentInicioSesionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicioSesionBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btCrear.setOnClickListener {
            findNavController().navigate(R.id.crearCuentaFragment)
        }

        //Niños
        binding.btIniciarLogin.setOnClickListener {
            var dbusuario: DbUsuario = context?.let { DbUsuario(it) }!!
            var usuario = dbusuario.verifyUsuario(binding.etUsuario.text.toString(), binding.etContra.text.toString())

            if(usuario.id_rol==1){
                Toast.makeText(context,"Bienvenido ${usuario.nombre_real}",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.sesionGenFragment)
            }else if(usuario.id_rol==2){
                Toast.makeText(context,"Holi ${usuario.nombre_real}",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.menuNinosFragment)
            }

            if(usuario.id_rol==0) {
                Toast.makeText(context,"No se encontro un usuario coincidente",Toast.LENGTH_SHORT).show()
            }
        }
    }
}