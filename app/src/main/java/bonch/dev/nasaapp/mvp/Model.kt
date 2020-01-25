package bonch.dev.nasaapp.mvp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.MainContract
import bonch.dev.nasaapp.adapters.DayAdapter
import bonch.dev.nasaapp.api.NasaApi
import bonch.dev.nasaapp.api.NasaService
import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO
import com.bumptech.glide.load.HttpException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Model(val pres: Presenter) : MainContract.Model, AppCompatActivity() {
    lateinit var dates: List<DateDTO>
    val nasaService = NasaService.makeNasaService()
    lateinit var app: Presenter
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        app = pres
    }

    override suspend fun loadDates(): List<DateDTO> {
        val response = nasaService.getDatesWithPhoto()

        try {
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    dates = response.body()!!
                }
            }
        } catch (err: HttpException) {
            Log.e("Retrofit", "${err.printStackTrace()}")
        }

        return dates
    }
    override suspend fun loadDay(date: String): List<PhotoDTO> {
        val response = nasaService.getPhotosForDate(date)
        lateinit var days: List<PhotoDTO>


        try {
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    days = response.body()!!
                }
            }
        } catch (err: HttpException) {
            Log.e("Retrofit", "${err.printStackTrace()}")
        }

        return days
    }
}