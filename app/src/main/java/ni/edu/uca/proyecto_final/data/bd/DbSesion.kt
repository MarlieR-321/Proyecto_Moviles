package ni.edu.uca.proyecto_final.data.bd

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Sesion
import ni.edu.uca.proyecto_final.data.entidades.Usuario
import java.util.*

//Clase en la que se manejan las sentencias de esta tabla

@RequiresApi(Build.VERSION_CODES.P)
class DbSesion(context: Context): DbHelper(context) {
    private val dbHelper = DbHelper(context)


    fun  mostrarSesion():MutableList<Sesion>{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase

        var listaSesion = mutableListOf<Sesion>()

        var cursor:Cursor = db.rawQuery("SELECT * FROM $VIEW_SESION ORDER BY id_sesion DESC",null)

        if(cursor.moveToFirst()){
            do{
                val sesion = Sesion()
                sesion.id_sesion = cursor.getInt(0)
                sesion.fecha_sesion = cursor.getString(1)
                sesion.id_usuario = cursor.getInt(2)
                sesion.nombre_usuario = cursor.getString(3)

                listaSesion?.add(sesion)
            }while (cursor.moveToNext())
            cursor.close()
        }
        return listaSesion!!
    }

    fun nuevaSesion(){
        val now:Calendar = Calendar.getInstance()
        val datetime:String = "${now.get(Calendar.DATE)}/${now.get(Calendar.MONTH)}/${now.get(Calendar.YEAR)} - ${now.get(Calendar.HOUR_OF_DAY)}:${now.get(Calendar.MINUTE)}:${now.get(Calendar.SECOND)}"

        try{
            val db: SQLiteDatabase = dbHelper!!.writableDatabase
            var values = ContentValues()

            values.put("fechaSesion",datetime)
            values.put("id_usuario", Usuario.id_usuario)

            db.insert(TABLE_SESION,null,values)
        } catch(ex:Exception) {
            ex.toString()
        }

    }

    fun getId():Int{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase
        var cursor:Cursor = db.rawQuery("SELECT id_sesion FROM $TABLE_SESION ORDER BY id_sesion desc LIMIT 1",null)
        cursor.moveToFirst()
        val id = cursor.getInt(0)
        cursor.close()
        return id
    }

}