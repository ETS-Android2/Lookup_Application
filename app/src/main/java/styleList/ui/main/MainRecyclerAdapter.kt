package styleList.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.R
//import com.styleList.androiddata.R
import styleList.data.Stylelist
import styleList.utilities.PrefsHelper
import com.hedgehog.ratingbar.RatingBar
import network.RetrofitClient
import network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import styleList.data.RatingData
import styleList.data.RatingResponse


class MainRecyclerAdapter(val context: Context,
                          val stylelists: List<Stylelist>, val itemListener: StylelistItemListener):
        Adapter<MainRecyclerAdapter.ViewHolder>() {

    var ratingData:RatingData?=null

    override fun getItemCount() = stylelists.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutStyle = PrefsHelper.getItemType(parent.context)
        val layoutId = if (layoutStyle == "grid") {
            R.layout.stylelist_grid_item
        } else {
            R.layout.stylelist_list_item
        }
        val view = inflater.inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stylelist = stylelists[position]


        with(holder) {
            nameText?.let {
                it.text = stylelist.imageFile
                it.contentDescription = stylelist.imageFile

            }


            grading?.setOnRatingChangeListener(
                    RatingBar.OnRatingChangeListener { RatingCount ->
                        Toast.makeText(
                                context,
                                "the fill star is$RatingCount",
                                Toast.LENGTH_SHORT
                        ).show()
                        stylelist.rating = RatingCount.toInt()
                        ratingData= RatingData(stylelist.userId,stylelist.imageID,stylelist.rating)
                        RatingUpdate(ratingData!!)
                    }


            )
            grading.setStar(stylelist.rating.toFloat())

            /*grading.setOnRatingBarChangeListener{
                 ratingBar, rating, fromUser ->
                 grading.onRatingBarChangeListener
                 Toast.makeText(context, "$rating", Toast.LENGTH_SHORT).show()
                 //monster.like=rating.toDouble()
                 monster.scariness=rating.toInt()
             }*/
            //grading?.rating=onRatingChanged(ratingBar = grading,rating = grading.rating,fromUser = Boolean)

            //grading?.rating = monster.like.toFloat()
            // grading?.rating = monster.scariness.toFloat()


            Glide.with(context)
                    .asBitmap()
                    .apply { RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)}
                    .apply { RequestOptions.skipMemoryCacheOf(true) }
                    .load("${stylelist.thumbnailUrl}")
                    .into(stylelistImage)

            holder.itemView.setOnClickListener {
                itemListener.onMonsterItemClick(stylelist)
            }
        }
    }

    inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
        val stylelistImage = itemView.findViewById<ImageView>(R.id.monsterImage)
        val grading = itemView.findViewById<com.hedgehog.ratingbar.RatingBar>(R.id.ratingBar)
        /*override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        Toast.makeText(context, "$rating", Toast.LENGTH_SHORT).show()
        grading.numStars="$rating".toInt()
    }*/


    }


    interface StylelistItemListener {
        fun onMonsterItemClick(stylelist: Stylelist)
    }

    fun RatingUpdate(ratingData: RatingData){
        val servcie: ServiceApi?= RetrofitClient.getClient().create(ServiceApi::class.java)
        servcie?.updateStyleRating(ratingData)?.enqueue(object : Callback<RatingResponse?> {
            override fun onFailure(call: Call<RatingResponse?>, t: Throwable) {
                print("Fail Load Rating")
            }

            override fun onResponse(call: Call<RatingResponse?>, response: Response<RatingResponse?>) {

                var result: RatingResponse? = response.body()
                if (response.body() != null) {
                    result = response.body()

                } else {
                    Log.v("알림", "rating 값이 없습니다.")

                }
            }

        })
    }

}