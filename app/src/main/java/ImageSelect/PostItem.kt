package ImageSelect

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostItem(
        val imageID:Int,val Purpose: Int,val image:Int
):Parcelable