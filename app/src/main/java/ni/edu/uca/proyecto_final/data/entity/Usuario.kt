package ni.edu.uca.proyecto_final.data.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "Usuario",
        foreignKeys = [ForeignKey(
            entity = Rol::class,
            parentColumns = ["id_rol"],
            childColumns = ["id_rol"])])
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id_usuario:Int =0,
    @ColumnInfo(name = "nombre_usuario")
    val nombre_usuario:String,
    @ColumnInfo(name = "correo")
    val correo:String,
    @ColumnInfo(name="nombre_real")
    val nombre_real:String,
    @ColumnInfo(name = "contrasena")
    val contrasena:String,
    @ColumnInfo(name = "id_rol")
    val id_rol:Int
    )

