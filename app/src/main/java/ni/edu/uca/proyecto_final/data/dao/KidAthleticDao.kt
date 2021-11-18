package ni.edu.uca.proyecto_final.data.dao

import android.content.ClipData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.proyecto_final.data.entity.Categoria_Ejercicios

@Dao
interface KidAthleticDao {
    @Query("SELECT * from Rol")
    fun getItems(): Flow<List<ClipData.Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(catEjer: Categoria_Ejercicios)
}