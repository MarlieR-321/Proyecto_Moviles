package ni.edu.uca.proyecto_final.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Ejercicio",
    foreignKeys = [ForeignKey(entity = Categoria_Ejercicios::class,
    parentColumns = ["id_categoria"],
    childColumns = ["id_categoria"])]
)
data class Ejercicio (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id_ejercicio")
    val id_ejercicio:Int,
    @ColumnInfo(name="nombre_ejercicio")
    val nombre_ejercicio:Int,
    @ColumnInfo(name="repeticion")
    val repeticion:String,
    @ColumnInfo(name="id_categoria")
    val id_categoria:Int
    )