package ni.edu.uca.proyecto_final.data.entidades

data class Usuario (
    val id_usuario:Int,
    val nombre_usuario:String,
    val correo:String,
    val nombre_real:String,
    val contrasena:String,
    val id_rol:Int
)

