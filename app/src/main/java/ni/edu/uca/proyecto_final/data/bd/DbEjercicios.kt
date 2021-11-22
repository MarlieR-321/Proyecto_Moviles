package ni.edu.uca.proyecto_final.data.bd

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import ni.edu.uca.proyecto_final.data.DbHelper
import ni.edu.uca.proyecto_final.data.entidades.Ejercicios

@RequiresApi(Build.VERSION_CODES.P)
class DbEjercicios(context: Context): DbHelper(context) {
    val dbHelper = DbHelper(context)


    fun  mostrarEjercicios(idCat: Int):MutableList<Ejercicios>{
        val db: SQLiteDatabase = dbHelper!!.writableDatabase
        var listaEjercicios = mutableListOf<Ejercicios>()
        var ejercicios = Ejercicios()

        var cursor:Cursor = db.rawQuery("SELECT * FROM $TABLE_EJERCICIOS WHERE id_categoria = idCat ",null)

        if(cursor.moveToFirst()){
            do{
                ejercicios.id_ejercicio = cursor.getInt(0)
                ejercicios.id_categoria = cursor.getInt(1)
                ejercicios.nombre_ejercicio = cursor.getString(2)
                ejercicios.repeticion = cursor.getString(3)

                listaEjercicios?.add(ejercicios)
            }while (cursor.moveToNext())
            cursor.close()
        }
        return listaEjercicios!!
    }

}