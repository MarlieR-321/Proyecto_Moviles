package ni.edu.uca.proyecto_final.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import ni.edu.uca.proyecto_final.data.entity.*
import androidx.room.RoomDatabase
import ni.edu.uca.proyecto_final.data.dao.KidAthleticDao

@Database(entities = [  Categoria_Ejercicios::class,
                        Ejercicio::class,
                        Rol::class,
                        Usuario::class,
                        Sesion::class,
                        Sesion_Detalle::class],
                    version = 1, exportSchema =false)

abstract class KidAthleticRoom :RoomDatabase(){
    abstract fun kidADao(): KidAthleticDao

    companion object {
        @Volatile
        private var INSTANCE: KidAthleticRoom? = null

        fun getDatabase(context: Context): KidAthleticRoom {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KidAthleticRoom::class.java,
                    "kidA_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
                instance
            }
        }
    }
}