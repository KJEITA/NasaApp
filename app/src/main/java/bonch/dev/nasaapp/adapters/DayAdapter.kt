package bonch.dev.nasaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.mvp.app
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DayAdapter(val context: Context) :
    RecyclerView.Adapter<ItemPostHolder>() {

    var dates = ArrayList<DateDTO>()

    fun setDatess(dates: List<DateDTO>) {
        this.dates.clear()
        this.dates.addAll(dates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.day_item, parent, false)
        )
    }

    override fun getItemCount(): Int = dates.size

    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {
        val post = dates[position]
        holder.bind(post)
    }
}

class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textDate = itemView.findViewById<TextView>(R.id.date)

    fun bind(date: DateDTO) {
        textDate.text = date.date

        val inDayAdapter = InDayAdapter(itemView.context)

        val recyclerViewDay = itemView.findViewById<RecyclerView>(R.id.dayRecyclerView)
        recyclerViewDay.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewDay.layoutManager
        recyclerViewDay.adapter = inDayAdapter

        CoroutineScope(Dispatchers.Main).launch {
            inDayAdapter.setDatess(app.getDay(date.date))
        }
    }
}