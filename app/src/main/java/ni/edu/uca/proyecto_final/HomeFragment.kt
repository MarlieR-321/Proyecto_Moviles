package ni.edu.uca.proyecto_final

import android.database.sqlite.SQLiteDatabase
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAbout.setOnClickListener {
            findNavController().navigate(R.id.aboutFragment)
        }

        binding.btnIniciar.setOnClickListener {
            val dbHelper = context?.let { it1 -> DbHelper(it1) }
            val db: SQLiteDatabase = dbHelper!!.writableDatabase
            findNavController().navigate(R.id.inicioSesionFragment)
        }
    }
}