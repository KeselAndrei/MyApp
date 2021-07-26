package com.gmail.keseltms.myapp.homework19.cloud


import com.gmail.keseltms.myapp.BuildConfig
import com.gmail.keseltms.myapp.homework19.repository.ApiRepository.Companion.CITY
import com.gmail.keseltms.myapp.homework19.repository.ApiRepository.Companion.LANG
import com.gmail.keseltms.myapp.homework19.repository.ApiRepository.Companion.UNITS
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(BuildConfig.GET_API_KEY_WEATHER)
    suspend fun getWeather(
        @Query("q") nameCity: String = CITY,
        @Query("lang") lang: String = LANG,
        @Query("units") units: String = UNITS,
    ): WeatherResponse

    companion object {
        fun get(): WeatherApi = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
            )
            .build().create(WeatherApi::class.java)
    }
}