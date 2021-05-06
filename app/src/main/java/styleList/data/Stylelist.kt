package styleList.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import styleList.IMAGE_BASE_URL
//import com.styleList.androiddata.R
import com.squareup.moshi.Json

@Entity(tableName = "stylelists")
data class Stylelist (
        @PrimaryKey(autoGenerate = true)
        val imageID: Int,
        val imageFile: String,
        val coordiID: Int,
        val temp:Int,
        val userId: String,
        var rating: Int

) {
    val imageUrl
        get() = "$IMAGE_BASE_URL/$imageFile.webp"
    val thumbnailUrl
        get() = "$IMAGE_BASE_URL/${imageFile}_tn.webp"
}
