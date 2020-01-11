package bonch.dev.nasaapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.adapters.DayAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var disposable: CompositeDisposable
    lateinit var recyclerView: RecyclerView
    var adapter = DayAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        disposable = CompositeDisposable()

        recyclerView = findViewById(R.id.main_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter

        val app = application as App
        CoroutineScope(Dispatchers.IO).launch {
            disposable.add(
                app
                    .getNasaServicee()
                    .getApii()
                    .getDatesWithPhoto()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { dates, throwable ->
                        if (throwable != null) {
                            Toast.makeText(
                                this@MainActivity,
                                "Data loading error",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            adapter.setDatess(dates)
                        }
                    }
            )
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
