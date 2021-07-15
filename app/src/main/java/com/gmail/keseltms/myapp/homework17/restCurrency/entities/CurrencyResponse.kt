package com.gmail.keseltms.myapp.homework17.restCurrency.entities

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("data") val data: List<CurrencyEntity>,
    @SerializedName("status") val status: StatusEntity
)