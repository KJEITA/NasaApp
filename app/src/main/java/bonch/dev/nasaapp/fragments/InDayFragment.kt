package bonch.dev.nasaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.api.model.PhotoDTO
import bonch.dev.nasaapp.mvp.app
import com.bumptech.glide.Glide

class InDayFragment : Fragment() {

    lateinit var image: ImageView
    lateinit var vieww: View
    lateinit var photoDTO:PhotoDTO

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vieww = inflater.inflate(R.layout.fragment_inday, container, false)

        image = vieww.findViewById(R.id.indayPhoto)

        image.setOnClickListener(){
            app.showInfo(photoDTO)
        }

        setPhoto()

        return vieww
    }

    fun setPhoto() {
        Glide.with(vieww.context).load(photoDTO.getImageUrl()).into(image)
    }
    fun setData(data:PhotoDTO){
        photoDTO = data
    }
}