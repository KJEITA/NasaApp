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
        suspend fun getDate():List<DateDTO>
        suspend fun getDay(date:String):List<PhotoDTO>
    }

    interface Model{
        suspend fun loadDates():List<DateDTO>
        suspend fun loadDay(date:String):List<PhotoDTO>
    }
}