package bonch.dev.nasaapp.mvp

import android.app.Application
import bonch.dev.nasaapp.MainContract
import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO

class Presenter : MainContract.Presenter, Application() {
    lateinit var view: MainActivity
    lateinit var model: Model

    override fun onCreate() {
        super.onCreate()

        model = Model(this)


    }

    override fun onItemWasClicked(data: PhotoDTO) {
        view.showInDay(data)
    }

    override fun showInfo(data: PhotoDTO) {
        view.showInfo(data)
    }

    override fun setVieww(view: MainActivity) {
        this.view = view
    }

    override suspend fun getDate(): List<DateDTO> {
        return model.loadDates()
    }

    override suspend fun getDay(date: String): List<PhotoDTO> {
        return model.loadDay(date)
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}