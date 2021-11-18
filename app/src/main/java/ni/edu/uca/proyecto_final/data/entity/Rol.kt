package ni.edu.uca.proyecto_final.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rol (
    @PrimaryKey(autoGenerate = true)
    val id_rol:Int =0,
    @ColumnInfo(name = "nombre_rol")
    val nombre_rol:String)
