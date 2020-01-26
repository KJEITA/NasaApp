package bonch.dev.nasaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.api.model.PhotoDTO
import com.bumptech.glide.Glide

class InfoFragment : Fragment() {

    lateinit var text: TextView
    lateinit var vieww: View
    lateinit var photoDTO: PhotoDTO

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vieww = inflater.inflate(R.layout.fragment_info, container, false)

        text = vieww.findViewById(R.id.infoText)

        setText()

        return vieww
    }

    fun setText() {
        text.text = photoDTO.identifier
    }

    fun setData(data: PhotoDTO) {
        photoDTO = data
    }
}