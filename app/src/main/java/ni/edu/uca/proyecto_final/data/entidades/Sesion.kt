package ni.edu.uca.proyecto_final.data.entidades

import java.sql.Date

data class Sesion (
    var id_sesion: Int,
    var fecha_sesion: String,
    var id_usuario:Int
)