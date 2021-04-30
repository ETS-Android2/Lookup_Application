package styleList.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StylelistDao {

    @Query("SELECT * from stylelists")
    fun getAll(): List<Stylelist>

    @Query("UPDATE stylelists SET scariness =:mScari  WHERE monsterId =:mId ")
    fun dataUpdate(mId: Int?, mScari: Int?)

    @Update
    fun update(stylelists: List<Stylelist>)

    @Insert
    suspend fun insertStylelist(stylelist: Stylelist)

    @Insert
    suspend fun insertStylelists(stylelists: List<Stylelist>)

    @Query("DELETE from stylelists")
    suspend fun deleteAll()

}