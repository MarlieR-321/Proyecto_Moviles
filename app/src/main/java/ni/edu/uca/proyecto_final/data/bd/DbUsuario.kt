package ni.edu.uca.proyecto_final.data.bd

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Usuario

@RequiresApi(Build.VERSION_CODES.P)
class DbUsuario(context:Context): DbHelper(context) {
    val dbHelper = DbHelper(context)

    fun verifyUsuario(name:String,pwd:String):Usuario{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase
        var usuario = Usuario()

        var cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_USUARIO WHERE nombre_usuario='$name' AND contrasena='$pwd'",null)

        if(cursor.moveToFirst()){
            usuario.id_usuario = cursor.getInt(0)
            usuario.id_rol = cursor.getInt(1)
            usuario.nombre_usuario = cursor.getString(2)
            usuario.nombre_real = cursor.getString(4)
            usuario.contrasena = cursor.getString(5)
            return usuario
        }else{
            usuario.id_rol=0
        }
        return usuario
    }

    fun insertarUsuario( nombre_real:String,nombre_Usuario:String, contrasena: String,rol: Int,correo:String){

        try {
            val db: SQLiteDatabase = dbHelper!!.writableDatabase
            var values = ContentValues()

            values.put("nombre_real",nombre_real)
            values.put("nombre_usuario",nombre_Usuario)
            values.put("correo",correo)
            values.put("contrasena",contrasena)
            values.put("id_rol",rol)

            db.insert(TABLE_USUARIO,null,values)
        }
        catch (ex:Exception){
            ex.toString()
        }
    }
}