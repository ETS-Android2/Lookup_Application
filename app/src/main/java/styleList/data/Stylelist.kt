package styleList.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import styleList.IMAGE_BASE_URL
//import com.styleList.androiddata.R
import com.squareup.moshi.Json

@Entity(tableName = "stylelists")
data class Stylelist (
        @PrimaryKey(autoGenerate = true)
        /* val imageID: Int,
         val imageFile: String,
         val style: List,
         val coordiID: Int,
         val coordi:List,
         val temp:Int,
         val user_like:List*/
        val monsterId: Int,
        val monsterName: String,
        val imageFile: String,
        val caption: String,
        val description: String,
        val price: Double,
        var scariness: Int
        //var like: Double

) {
    val imageUrl
        get() = "$IMAGE_BASE_URL/$imageFile.webp"
    val thumbnailUrl
        get() = "$IMAGE_BASE_URL/${imageFile}_tn.webp"
}
