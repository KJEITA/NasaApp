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


class MainActivity : MainContract.View, AppCompatActivity() {

    lateinit var recyclerViewDay: RecyclerView
    lateinit var recyclerViewInDay: RecyclerView

    private lateinit var adapterDay: DayAdapter
    private lateinit var adapterInDay: InDayAdapter

    val fragmentManager = supportFragmentManager
    lateinit var app:Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app = application as Presenter

        app.setVieww(this)

        showMain()
    }

    override fun showMain() {
        fragmentManager.beginTransaction().add(R.id.fragment,
            MainFragment()
        )
            .commit()

        adapterDay = DayAdapter(applicationContext)
        adapterInDay = InDayAdapter(applicationContext)

        var fragmentView = fragmentManager.findFragmentById(R.id.fragment)?.view

        if (fragmentView != null) {
            setAdapters(fragmentView)
        }
        setDate(app.getDate())
    }

    override fun showInDay() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setAdapters(view: View) {
        recyclerViewDay = view.findViewById(R.id.main_recycler_view)
        recyclerViewDay.layoutManager = LinearLayoutManager(view.context)
        recyclerViewDay.adapter = adapterDay

        recyclerViewInDay = view.findViewById(R.id.dayRecyclerView)
        recyclerViewInDay.layoutManager = LinearLayoutManager(view.context)
        recyclerViewInDay.adapter = adapterDay
    }

    fun setDate(date: List<DateDTO>) {
        adapterDay.setDatess(date)
    }
}
