package ni.edu.uca.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAerobicos.setOnClickListener {
            findNavController().navigate(R.id.ejerciciosFragment)
        }
        binding.btnCalentamiento.setOnClickListener {
            findNavController().navigate(R.id.ejerciciosFragment)
        }
        binding.btnCardio.setOnClickListener {
            findNavController().navigate(R.id.ejerciciosFragment)
        }
        binding.btnPiernas.setOnClickListener {
            findNavController().navigate(R.id.ejerciciosFragment)
        }
        binding.btnYoga.setOnClickListener {
            findNavController().navigate(R.id.ejerciciosFragment)
        }
        binding.btnSalir.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

    }
}