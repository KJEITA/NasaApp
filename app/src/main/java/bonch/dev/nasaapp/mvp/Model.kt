package bonch.dev.nasaapp.mvp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.MainContract
import bonch.dev.nasaapp.adapters.DayAdapter
import bonch.dev.nasaapp.api.NasaService
import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Model(val pres: Presenter) : MainContract.Model, AppCompatActivity() {
    lateinit var dates: List<DateDTO>
    lateinit var disposable: CompositeDisposable
    val nasaService = NasaService()
    lateinit var app: Presenter
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        app = pres
    }

    override fun loadDates(): List<DateDTO> {


        disposable = CompositeDisposable()

        /*recyclerView = findViewById(R.id.main_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter*/



        CoroutineScope(Dispatchers.IO).launch {
            disposable.add(
                nasaService
                    .getApii()
                    .getDatesWithPhoto()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { listDates, throwable ->
                        if (throwable != null) {
                            Toast.makeText(
                                this@Model,
                                "Data loading error",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            dates = listDates
                        }
                    }
            )
        }
    }

    override fun loadDay(date: String): List<PhotoDTO> {
        lateinit var days: List<PhotoDTO>
        val app = application as Presenter
        CoroutineScope(Dispatchers.IO).launch {
            disposable.add(
                app
                    .nasaService
                    .getApii()
                    .getPhotosForDate(date)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { listDates, throwable ->
                        if (throwable != null) {
                            Toast.makeText(
                                this@Model,
                                "Data loading error",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            days = listDates
                        }
                    }
            )
        }
        return days
    }

    /*override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }*/
}