package ni.edu.uca.proyecto_final.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "Sesion",
    foreignKeys = [ForeignKey(
        entity = Usuario::class,
        parentColumns = ["id_usuario"],
        childColumns = ["id_usuario"]
    )]
)
data class Sesion (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id_sesion")
    val id_sesion: Int =0,
    @ColumnInfo(name = "fecha_sesion")
    val fecha_sesion:Date,
    @ColumnInfo(name = "id_usuario")
    val id_usuario:Int
    )