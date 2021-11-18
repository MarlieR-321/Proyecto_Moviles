package ni.edu.uca.proyecto_final.data

import android.app.Application

class KidAAplication: Application() {
    val database: KidAthleticRoom by lazy { KidAthleticRoom.getDatabase(this) }
}