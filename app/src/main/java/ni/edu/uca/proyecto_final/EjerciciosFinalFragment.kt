package ni.edu.uca.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.databinding.FragmentEjerciciosFinalBinding

class EjerciciosFinalFragment : Fragment() {
    private lateinit var binding: FragmentEjerciciosFinalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEjerciciosFinalBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegresar.setOnClickListener {
            findNavController().navigate(R.id.menuNinosFragment)
        }
    }
}