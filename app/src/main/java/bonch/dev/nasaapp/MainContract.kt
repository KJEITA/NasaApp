package bonch.dev.nasaapp

import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO
import bonch.dev.nasaapp.mvp.MainActivity

interface MainContract {

    interface View {
        fun showMain()
        fun showInDay()
        fun showInfo()
    }

    interface Presenter {
        fun onItemWasClicked()
        fun onDestroy()
        fun setVieww(view: MainActivity)
        fun getDate():List<DateDTO>
        fun getDay(date:String):List<PhotoDTO>
    }

    interface Model{
        fun loadDates():List<DateDTO>
        fun loadDay(date:String):List<PhotoDTO>
    }
}