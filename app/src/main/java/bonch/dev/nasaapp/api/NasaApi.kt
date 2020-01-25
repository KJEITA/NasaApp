package bonch.dev.nasaapp.api

import bonch.dev.nasaapp.api.model.DateDTO
import bonch.dev.nasaapp.api.model.PhotoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NasaApi{
    @GET("natural/all?api_key=bUPDj3NcY7TPvoShGVEilLJJmiYHzdqyirJx04n4")
    suspend fun getDatesWithPhoto() : Response<List<DateDTO>>

    @GET("natural/date/{date}?api_key=bUPDj3NcY7TPvoShGVEilLJJmiYHzdqyirJx04n4")
    suspend fun getPhotosForDate(@Path("date") date:String):Response<List<PhotoDTO>>
}