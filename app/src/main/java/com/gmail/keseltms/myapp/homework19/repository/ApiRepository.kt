package com.gmail.keseltms.myapp.homework19.repository

import com.gmail.keseltms.myapp.homework19.cloud.WeatherApi
import com.gmail.keseltms.myapp.homework19.data.WeatherResult

class ApiRepository(
    private val weatherApi: WeatherApi
) {
    suspend fun getApiResult(): WeatherResult = WeatherResult(

        weatherApi.getWeather().weather.map {
            it.description
        }.toString(),
        weatherApi.getWeather().name,
        weatherApi.getWeather().main.temp,
        weatherApi.getWeather().weather.map {
            it.icon
        }.toString()
    )

    companion object {
        const val CITY: String = "Минск"
        const val LANG = "ru"
        const val UNITS = "metric"
    }
}