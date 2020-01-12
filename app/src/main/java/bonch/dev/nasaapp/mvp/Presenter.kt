package bonch.dev.nasaapp.mvp

import android.app.Application
import bonch.dev.nasaapp.MainContract
import bonch.dev.nasaapp.api.NasaService
import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO

class Presenter : MainContract.Presenter, Application() {
    lateinit var nasaService: NasaService
    lateinit var view: MainActivity
    lateinit var model: Model

    override fun onCreate() {
        super.onCreate()

        nasaService = NasaService()
        model = Model(this)

    }

    override fun onItemWasClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVieww(view: MainActivity) {
        this.view = view
    }

    override fun getDate(): List<DateDTO> {
        return model.loadDates()
    }

    override fun getDay(date: String): List<PhotoDTO> {
        return model.loadDay(date)
    }
}