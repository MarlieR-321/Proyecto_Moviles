package ni.edu.uca.proyecto_final.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ni.edu.uca.proyecto_final.data.dao.KidAthleticDao
import ni.edu.uca.proyecto_final.data.entity.Categoria_Ejercicios
import kotlinx.coroutines.launch

class KidAViewModel (private val kidaDao:KidAthleticDao): ViewModel() {

    private fun insertItem(catEjerc: Categoria_Ejercicios) {
        viewModelScope.launch {
            kidaDao.insert(catEjerc)
        }
    }

    private fun getNewItemEntry(catName: String, catDesc: String): Categoria_Ejercicios {
        return Categoria_Ejercicios(
            nombre_categoria = catName,
            descripcion = catDesc
        )
    }

    fun addNewItem(catName: String, catDesc: String) {
        val newItem = getNewItemEntry(catName, catDesc)
        insertItem(newItem)
    }

    fun isEntryValid(catName: String, catDesc: String): Boolean {
        if (catName.isBlank() || catDesc.isBlank()) {
            return false
        }
        return true
    }

}

class KidAViewModelFactory(private val kidaDao: KidAthleticDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KidAViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return KidAViewModel(kidaDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}