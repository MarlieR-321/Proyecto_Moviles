package ni.edu.uca.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.KidAAplication
import ni.edu.uca.proyecto_final.data.KidAViewModel
import ni.edu.uca.proyecto_final.data.KidAViewModelFactory
import ni.edu.uca.proyecto_final.data.entity.Categoria_Ejercicios
import ni.edu.uca.proyecto_final.databinding.FragmentPruebaBinding

class prueba : Fragment() {
    private val viewModel: KidAViewModel by activityViewModels {
        KidAViewModelFactory(
            (activity?.application as KidAAplication)
                .database
                .kidADao()
        )
    }

    lateinit var ce: Categoria_Ejercicios

    private lateinit var binding: FragmentPruebaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPruebaBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.edtName.text.toString(),
            binding.etnDescripcion.text.toString()
        )
    }

    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.edtName.text.toString(),
                binding.etnDescripcion.text.toString(),
            )
            findNavController().navigate(R.id.fragment_2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button8.setOnClickListener {
            addNewItem()
        }
    }





}