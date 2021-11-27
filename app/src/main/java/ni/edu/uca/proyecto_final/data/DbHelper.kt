package ni.edu.uca.proyecto_final.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi



@RequiresApi(Build.VERSION_CODES.P)
open class DbHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NOMBRE,null,DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE "+ TABLE_USUARIO +"("+
                "id_Usuario  INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_rol INTEGER,"+
                "nombre_usuario VARCHAR NOT NULL,"+
                "correo VARCHAR NULL,"+
                "nombre_real TEXT NOT NULL,"+
                "contrasena VARCHAR NOT NULL,"+
                "FOREIGN KEY(id_rol) REFERENCES "+TABLE_ROL+")")

        db?.execSQL(" CREATE TABLE "+ TABLE_ROL+"("+
                "id_rol INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre_rol VARCHAR NOT NULL)");

        db?.execSQL("CREATE TABLE "+ TABLE_CATEGORIAE+"("+
                "id_categoria INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre_cat VARCHAR NOT NULL,"+
                "descripcion VARCHAR NOT NULL)")

        db?.execSQL("CREATE TABLE "+ TABLE_EJERCICIOS+ "("+
                "id_ejercicio INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_categoria INTEGER,"+
                "nombre_ejercicio VARCHAR NOT NULL,"+
                "repeticion VARCHAR NOT NULL,"+
                " FOREIGN KEY (id_categoria) REFERENCES "+ TABLE_CATEGORIAE+"(id_categoria) )")

        db?.execSQL("CREATE TABLE "+ TABLE_SESION+"("+
                "id_sesion INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "fechaSesion VARCHAR NOT NULL, "+
                "id_usuario INTEGER NOT NULL, " +
                "FOREIGN KEY (id_usuario) REFERENCES "+TABLE_USUARIO+"(id_usuario) )")

        db?.execSQL("CREATE TABLE "+ TABLE_SESION_DETALLES+"("+
                "id_sesion_det INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_sesion VARCHAR NOT NULL,"+
                "id_ejercicio INTEGER NOT NULL, " +
                "FOREIGN KEY (id_sesion) REFERENCES "+TABLE_SESION+"(id_sesion), "+
                "FOREIGN KEY (id_ejercicio) REFERENCES "+TABLE_EJERCICIOS+"(id_ejercicio) )")

        db?.execSQL("Create view $VIEW_SESION as Select s.id_sesion, s.fechaSesion,s.id_usuario, u.nombre_usuario FROM $TABLE_SESION s INNER JOIN $TABLE_USUARIO u on (u.id_Usuario = s.id_usuario)")
        db?.execSQL("Create view $VIEW_SESION_DET as Select s.id_sesion_det, s.id_sesion,s.id_ejercicio, e.nombre_ejercicio,e.repeticion FROM $TABLE_SESION_DETALLES s INNER JOIN $TABLE_EJERCICIOS e on (e.id_ejercicio = s.id_ejercicio)")


        db?.execSQL("INSERT INTO $TABLE_ROL(nombre_rol) VALUES ('Tutor')")
        db?.execSQL("INSERT INTO $TABLE_ROL(nombre_rol) VALUES ('Protegido')")
        db?.execSQL("INSERT INTO $TABLE_USUARIO(id_rol,nombre_usuario,nombre_real,contrasena) VALUES (1,'prueba','Prueba','123')")
        db?.execSQL("INSERT INTO $TABLE_USUARIO(id_rol,nombre_usuario,nombre_real,contrasena) VALUES (2,'coso','Coso','122')")


        db?.execSQL("INSERT INTO $TABLE_CATEGORIAE(id_categoria,nombre_cat,descripcion) VALUES (1,'Calentamiento','Eleva la temperatura para que los músculos y las articulaciones se pongan en funcionamiento y estén preparados para el esfuerzo posterior.')")
        db?.execSQL("INSERT INTO $TABLE_CATEGORIAE(id_categoria,nombre_cat,descripcion) VALUES (2,'Piernas','Quema más calorías y entrenar algunos músculos.')")
        db?.execSQL("INSERT INTO $TABLE_CATEGORIAE(id_categoria,nombre_cat,descripcion) VALUES (3,'Cardio','Disminuye el riesgo de enfermedades del corazón y ayuda a quemar grasa')")
        db?.execSQL("INSERT INTO $TABLE_CATEGORIAE(id_categoria,nombre_cat,descripcion) VALUES (4,'Aerobicos','Aumentar la resistencia, el estado físico y la fuerza')")
        db?.execSQL("INSERT INTO $TABLE_CATEGORIAE(id_categoria,nombre_cat,descripcion) VALUES (5,'Yoga','Conecta el cuerpo, la respiración y la mente.')")

        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (1,'Brazos','15 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (1,'Brazos direccion horizontal','15 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (1,'Salto estrella','10 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (1,'Unsplash','15 repeticiones')")

        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (2,'Sentadillas','10 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (2,'Tijeras','15 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (2,'Sentadillas rebote','20 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (2,'Elevacion de piernas','10 repeticiones')")

        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (3,'Boxeador','30 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (3,'Salto jump-star','15 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (3,'Salto de mano-180','10 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (3,'Salto una pierna laterales','10 repeticiones')")

        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (4,'Abrazo rodilla','10 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (4,'Frog crunch','10 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (4,'Impulso','10 repeticiones')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (4,'Escalador de montaña','15 repeticiones')")

        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (5,'Equilibrio estirado','20 segundos')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (5,'Grulla','10 segundos')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (5,'Tringulo','25 segundos')")
        db?.execSQL("INSERT INTO $TABLE_EJERCICIOS(id_categoria,nombre_ejercicio,repeticion) VALUES (5,'Arco en una pierna','30 segundos')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//            db?.execSQL("DROP VIEW $VIEW_SESION_DET")
            db?.execSQL("DROP VIEW $VIEW_SESION")
            db?.execSQL("DROP TABLE $TABLE_USUARIO")
            db?.execSQL("DROP TABLE $TABLE_ROL")
            db?.execSQL("DROP TABLE $TABLE_EJERCICIOS")
            db?.execSQL("DROP TABLE $TABLE_CATEGORIAE")
            db?.execSQL("DROP TABLE $TABLE_SESION")
            db?.execSQL("DROP TABLE $TABLE_SESION_DETALLES")
            onCreate(db)

    }

    companion object{
        const val DATABASE_VERSION = 15
        const val DATABASE_NOMBRE = "kidA_db"
        const val TABLE_USUARIO = "Usuario"
        const val TABLE_ROL = "Rol"
        const val TABLE_EJERCICIOS = "Ejercicios"
        const val TABLE_CATEGORIAE = "CategoriaEjercicio"
        const val TABLE_SESION = "Sesion"
        const val TABLE_SESION_DETALLES = "Sesion_Detalles"
        const val VIEW_SESION = "vw_Sesion"
        const val VIEW_SESION_DET = "vw_Sesion_Det"
    }
}