package ImageSelect
import Cookie.SaveSharedPreference
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import network.RetrofitClient
import network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.R

class SelectActivity2() : AppCompatActivity(), ActionMode.Callback {

    private var selectedPostItems: MutableList<PostItem> = mutableListOf()
    private var actionMode: ActionMode? = null
    private lateinit var adapter: PostsAdapter
    private var tracker: SelectionTracker<PostItem>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.purpose_select1)
        val postsRecyclerView: RecyclerView = findViewById(R.id.postsRecyclerView)
        var userId= SaveSharedPreference.getString(this.application.applicationContext, "ID");
        postsRecyclerView.isNestedScrollingEnabled = false
        postsRecyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val postItems: MutableList<PostItem> = mutableListOf()

        for(i in 1..20 step 1){
            var item:String="style"+i
            var item_image=getResources().getIdentifier(item,"drawable", getPackageName())
            postItems.add(PostItem(i,2,item_image))
        }



        adapter = PostsAdapter(this, postItems)
        postsRecyclerView.adapter = adapter

        tracker = SelectionTracker.Builder<PostItem>(
                "mySelection",
                postsRecyclerView,
                MyItemKeyProvider(adapter),
                MyItemDetailsLookup(postsRecyclerView),
                StorageStrategy.createParcelableStorage(PostItem::class.java)
        ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything()
        ).build()

        adapter.tracker = tracker

        tracker?.addObserver(
                object : SelectionTracker.SelectionObserver<Long>() {
                    override fun onSelectionChanged() {
                        super.onSelectionChanged()
                        tracker?.let {
                            selectedPostItems = it.selection.toMutableList()
                            var imagelist= mutableListOf<Int>()

                            for(item in selectedPostItems){
                                imagelist.add(item.imageID)
                            }
                            var postitemdata=PostItemData(userId,imagelist,2)
                            setItemUpdate(postitemdata)
                            Log.v("Selected ImageList: ",imagelist.toString())

                            if (actionMode == null) actionMode =
                                    startSupportActionMode(this@SelectActivity2)
                            actionMode?.title =
                                    "${selectedPostItems.size}"


                            /*if (selectedPostItems.isEmpty()) {
                                actionMode?.finish()
                            } else {
                                if (actionMode == null) actionMode =
                                        startSupportActionMode(this@SelectActivity)
                                actionMode?.title =
                                        "${selectedPostItems.size}"
                            }*/
                        }
                    }
                })
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_view_delete -> {
                Toast.makeText(
                        this,
                        selectedPostItems.toString(),
                        Toast.LENGTH_LONG
                ).show()
            }
        }
        return true
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        mode?.let {
            val inflater: MenuInflater = it.menuInflater
            inflater.inflate(R.menu.action_mode_menu, menu)
            return true
        }
        return false
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        //adapter.tracker?.clearSelection()
        adapter.notifyDataSetChanged()
        actionMode = null
    }

    fun setItemUpdate(data: PostItemData ){
        val servcie: ServiceApi?= RetrofitClient.getClient().create(ServiceApi::class.java)
        servcie?.setStylePurpose(data)?.enqueue(object: Callback<PostItemDataResponse?> {


            override fun onFailure(call: Call<PostItemDataResponse?>, t: Throwable) {
                print("Fail Load Rating")
            }


            override fun onResponse(call: Call<PostItemDataResponse?>, response: Response<PostItemDataResponse?>) {
                var result: PostItemDataResponse = response.body()!!
                if (response.body() != null) {
                    result = response.body()!!

                } else {
                    Log.v("알림", "response 값이 없습니다.")

                }
            }

        })
    }

}