package ni.edu.uca.proyecto_final.data.bd

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Sesion_Detalles
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
    fun MostrarDetalle(Id_Sesion:Int):MutableList<Sesion_Detalles>{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase
        var ListaSesion = mutableListOf<Sesion_Detalles>()
        var cursor: Cursor= db.rawQuery(" Select * from $VIEW_SESION_DET where id_sesion= '$Id_Sesion' ", null)
        if (cursor.moveToFirst()){
           do {
               val sesionDet= Sesion_Detalles()
               sesionDet.id_sesion_det=cursor.getInt(0)
               sesionDet.id_sesion=cursor.getInt(1)
               sesionDet.id_ejercicios=cursor.getInt(2)
               sesionDet.nombre_ejercicio=cursor.getString(3)
               sesionDet.repeticiones=cursor.getString(4)
               ListaSesion.add(sesionDet)
           }while (cursor.moveToNext())
           cursor.close()
        }
        return ListaSesion
    }

}
