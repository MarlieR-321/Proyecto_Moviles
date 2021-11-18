package ni.edu.uca.proyecto_final.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Categoria_Ejercicios(
    @PrimaryKey(autoGenerate = true)
    val id_categoria:Int = 0,
    @ColumnInfo(name="nombre_categoria")
    val nombre_categoria: String,
    @ColumnInfo(name = "descripcion")
    val descripcion: String
    )