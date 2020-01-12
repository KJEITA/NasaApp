package bonch.dev.nasaapp.api

import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface NasaApi{
    @GET("natural/all")
    fun getDatesWithPhoto() : Single<List<DateDTO>>

    @GET("natural/date/{date}")
    fun getPhotosForDate(@Path("date") date:String):Single<List<PhotoDTO>>
}