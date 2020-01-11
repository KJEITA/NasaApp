package bonch.dev.nasaapp

import android.app.Application
import bonch.dev.nasaapp.api.NasaService

class App: Application(){

    lateinit var nasaService: NasaService

    override fun onCreate() {
        super.onCreate()

        nasaService = NasaService()
    }

    //Я абсолютно не понимаю почему ругается если убрать одну из последних "e", в названии функции
    fun getNasaServicee():NasaService{
        return nasaService
    }
}