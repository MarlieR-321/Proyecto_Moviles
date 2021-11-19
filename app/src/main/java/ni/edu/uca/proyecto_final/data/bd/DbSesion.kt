package ni.edu.uca.proyecto_final.data.bd

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Sesion

@RequiresApi(Build.VERSION_CODES.P)
class DbSesion(context: Context): DbHelper(context) {
    val dbHelper = DbHelper(context)


    fun  mostrarSesion(id:Int):MutableList<Sesion>{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase

        lateinit var listaSesion: MutableList<Sesion>
        var sesion:Sesion = Sesion(0,"",0)
        var cursor:Cursor? =null

        cursor = db.rawQuery("SELECT * FROM $TABLE_SESION WHERE id_usuario = $id",null)

        if(cursor.moveToFirst()){
            do{
                sesion.id_sesion = cursor.getInt(0)
                sesion.fecha_sesion = cursor.getString(1)
                sesion.id_usuario = cursor.getInt(2)

                listaSesion?.add(sesion)
            }while (cursor.moveToNext())
            cursor.close()
        }else{
            listaSesion?.add(sesion)
        }
        return listaSesion!!
    }
}