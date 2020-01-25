package bonch.dev.nasaapp.adapters

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.api.model.PhotoDTO
import com.bumptech.glide.Glide

class InDayAdapter(val context: Context) : RecyclerView.Adapter<ItemInDayHolder>() {

    var dates = ArrayList<PhotoDTO>()

    fun setDatess(dates: List<PhotoDTO>) {
        this.dates.clear()
        this.dates.addAll(dates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemInDayHolder {
        return ItemInDayHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.inday_item, parent, false)
        )    }

    override fun getItemCount(): Int = dates.size

    override fun onBindViewHolder(holder: ItemInDayHolder, position: Int) {
        val post = dates[position]
        holder.bind(post)
    }
}

class ItemInDayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textDate = itemView.findViewById<TextView>(R.id.date_time)
    val imageView = itemView.findViewById<ImageView>(R.id.planet_image)
    fun bind(date: PhotoDTO) {

        textDate.text = date.date

        Glide.with(itemView.context)
            .load(date.getImageUrl())
            .into(imageView);
    }
}