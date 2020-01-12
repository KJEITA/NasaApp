package bonch.dev.nasaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.adapters.DayAdapter
import bonch.dev.nasaapp.adapters.InDayAdapter
import bonch.dev.nasaapp.api.model.DateDTO

class MainFragment : Fragment() {

    lateinit var recyclerViewDay: RecyclerView
    lateinit var recyclerViewInDay: RecyclerView

    private lateinit var adapterDay: DayAdapter
    private lateinit var adapterInDay: InDayAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        adapterDay = DayAdapter(view.context)
        adapterInDay = InDayAdapter(view.context)

        setAdapters(view)

        return view
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