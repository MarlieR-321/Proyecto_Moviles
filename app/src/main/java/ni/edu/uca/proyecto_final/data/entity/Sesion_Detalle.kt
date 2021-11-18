package ni.edu.uca.proyecto_final.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Sesion_Detalle",
    foreignKeys = [ForeignKey(
        entity = Sesion::class,
        parentColumns = ["id_sesion"],
        childColumns = ["id_sesion"]
    ),ForeignKey(
        entity = Sesion::class,
        parentColumns = ["id_ejercicio"],
        childColumns = ["id_ejercicio"]
    )]
)
data class Sesion_Detalle (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_sesion_det")
    val id_sesion_det:Int = 0,
    @ColumnInfo(name = "id_sesion")
    val id_sesion:Int,
    @ColumnInfo(name = "id_ejercicio")
    val id_ejercicio:Int,
    @ColumnInfo(name="realizado")
    val realizado:Int
        )