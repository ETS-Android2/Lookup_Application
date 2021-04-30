package styleList.data

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import android.widget.Toast.*
import androidx.annotation.WorkerThread
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import styleList.LOG_TAG
import styleList.WEB_SERVICE_URL
import styleList.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class StylelistRepository(val app: Application) {

    val stylelistData = MutableLiveData<List<Stylelist>>()
    private val stylelistDao = StylelistDatabase.getDatabase(app)
            .stylelistDao()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val data = stylelistDao.getAll()
            if (data.isEmpty()) {
                callWebService()
            } else {
                stylelistData.postValue(data)
                withContext(Dispatchers.Main) {
                    Toast.makeText(app, "Using local data", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @WorkerThread
    suspend fun callWebService() {
        if (networkAvailable()) {
            withContext(Dispatchers.Main) {
                Toast.makeText(app, "Using remote data", Toast.LENGTH_LONG).show()
            }
            Log.i(LOG_TAG, "Calling web service")
            val retrofit = Retrofit.Builder()
                    .baseUrl(WEB_SERVICE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            val service = retrofit.create(StylelistService::class.java)
            val serviceData = service.getStylelistData().body() ?: emptyList()
            stylelistData.postValue(serviceData)

            stylelistDao.deleteAll()
            stylelistDao.insertStylelists(serviceData)
        }
    }

    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }

    fun refreshDataFromWeb() {
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
        }
    }

    private fun saveDataToCache(stylelistData: List<Stylelist>) {
        if (ContextCompat.checkSelfPermission(
                        app,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                == PackageManager.PERMISSION_GRANTED
        ) {
            val moshi = Moshi.Builder().build()
            val listType = Types.newParameterizedType(List::class.java, Stylelist::class.java)
            val adapter: JsonAdapter<List<Stylelist>> = moshi.adapter(listType)
            val json = adapter.toJson(stylelistData)
            FileHelper.saveTextToFile(app, json)
        }
    }

    private fun readDataFromCache(): List<Stylelist> {
        val json = FileHelper.readTextFile(app)
        if (json == null) {
            return emptyList()
        }
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, Stylelist::class.java)
        val adapter: JsonAdapter<List<Stylelist>> = moshi.adapter(listType)
        return adapter.fromJson(json) ?: emptyList()
    }
}