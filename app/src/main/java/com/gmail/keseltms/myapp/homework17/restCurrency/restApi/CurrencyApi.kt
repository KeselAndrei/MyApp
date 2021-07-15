package com.gmail.keseltms.myapp.homework17.restCurrency.restApi

import com.gmail.keseltms.myapp.BuildConfig.API_KEY
import com.gmail.keseltms.myapp.homework17.restCurrency.entities.CurrencyResponse
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
}