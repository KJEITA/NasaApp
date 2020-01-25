package bonch.dev.nasaapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NasaService {
    private const val BASE_URL = "https://api.nasa.gov/EPIC/api/"

    fun makeNasaService(): NasaApi {

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create())
                .build()

        return retrofit.create(NasaApi::class.java)

    }
}