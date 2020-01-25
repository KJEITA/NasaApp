package bonch.dev.nasaapp.mvp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.MainContract
import bonch.dev.nasaapp.MainFragment
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.adapters.DayAdapter
import bonch.dev.nasaapp.adapters.InDayAdapter
import bonch.dev.nasaapp.api.model.DateDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var app: Presenter
class MainActivity : MainContract.View, AppCompatActivity() {

    lateinit var recyclerViewDay: RecyclerView

    private lateinit var adapterDay: DayAdapter

    val fragmentManager = supportFragmentManager

    val mainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app = application as Presenter

        app.setVieww(this)

        showMain()
    }

    override fun showMain() {
        fragmentManager.beginTransaction().add(
            R.id.fragment,
            mainFragment
        )
            .commitNow()

        CoroutineScope(Dispatchers.Main).launch {
            mainFragment.setDate(app.getDate())
        }
    }

    override fun showInDay() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
