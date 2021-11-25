package ni.edu.uca.proyecto_final.data.bd

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Sesion
import ni.edu.uca.proyecto_final.data.entidades.Usuario
import java.text.SimpleDateFormat
import java.util.*

//Clase en la que se manejan las sentencias de esta tabla

@RequiresApi(Build.VERSION_CODES.P)
class DbSesion(context: Context): DbHelper(context) {
    val dbHelper = DbHelper(context)


    fun  mostrarSesion():MutableList<Sesion>{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase

        var listaSesion = mutableListOf<Sesion>()
        var sesion = Sesion()
        var cursor:Cursor = db.rawQuery("SELECT * FROM $TABLE_SESION ORDER BY id_sesion",null)

        if(cursor.moveToFirst()){
            do{
                sesion.id_sesion = cursor.getInt(0)
                sesion.fecha_sesion = cursor.getString(1)
                sesion.id_usuario = cursor.getInt(2)

                listaSesion?.add(sesion)
            }while (cursor.moveToNext())
            cursor.close()
        }
        return listaSesion!!
    }

    fun nuevaSesion(){
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        Toast.makeText(null,currentDate,Toast.LENGTH_SHORT).show()
        try{
            val db: SQLiteDatabase = dbHelper!!.writableDatabase
            var values = ContentValues()

            values.put("fechaSesion",currentDate)
            values.put("id_usuario", Usuario.id_usuario)
            db.insert(TABLE_SESION,null,values)
        } catch(ex:Exception) {

        }

    }

    fun getId():Int{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase
        var cursor:Cursor = db.rawQuery("SELECT  id_sesion FROM $TABLE_SESION ORDER BY id_sesion desc LIMIT 1",null)
        val Id = cursor.getInt(0)
        cursor.close()
        return Id
    }

}