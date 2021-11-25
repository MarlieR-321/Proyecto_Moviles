package ni.edu.uca.proyecto_final.data.bd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Usuario

@RequiresApi(Build.VERSION_CODES.P)
class DbSesionDet(context: Context): DbHelper(context) {
    val dbHelper = DbHelper(context)

    fun InsertarDetalle(Id_Sesion:Int, Id_Ejercicio:Int){
        try{
            val db: SQLiteDatabase = dbHelper!!.writableDatabase
            var values = ContentValues()

            values.put("id_sesion",Id_Sesion)
            values.put("id_ejercicio",Id_Ejercicio)

            db.insert(TABLE_SESION_DETALLES,null,values)
        } catch(ex:Exception) {
            ex.toString()
        }

    }
}
