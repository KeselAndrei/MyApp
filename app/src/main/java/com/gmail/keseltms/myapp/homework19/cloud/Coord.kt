package com.gmail.keseltms.myapp.homework19.cloud

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)