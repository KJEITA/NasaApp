package bonch.dev.nasaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.adapters.DayAdapter
import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.mvp.app

class MainFragment : Fragment() {

    lateinit var recyclerViewDay: RecyclerView

    private lateinit var adapterDay: DayAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        adapterDay = DayAdapter(view.context)
        recyclerViewDay = view.findViewById(R.id.main_recycler_view)
        recyclerViewDay.layoutManager = LinearLayoutManager(view.context)
        recyclerViewDay.adapter = adapterDay

        return view
    }

    fun setDate(date: List<DateDTO>) {
        adapterDay.setDatess(date)
    }
}