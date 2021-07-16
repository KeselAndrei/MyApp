package com.gmail.keseltms.myapp.homework17.restCurrency.restApi

import com.gmail.keseltms.myapp.BuildConfig.API_KEY
import com.gmail.keseltms.myapp.BuildConfig.BASE_URL
import com.gmail.keseltms.myapp.homework17.restCurrency.entities.CurrencyResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CurrencyApi {

    @Headers("${API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getCurrencyLimitList(@Query("limit") limit: Int): CurrencyResponse

    @Headers("${API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getCurrencySortNameList(@Query("sort") sort: String = "name"): CurrencyResponse

    @Headers("${API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getCurrencySortNameAndLimitList(
        @Query("limit") limit: Int,
        @Query("sort") sort: String = "name"
    ): CurrencyResponse

    companion object {
        fun get(): CurrencyApi = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
            )
            .build().create(CurrencyApi::class.java)
    }
}