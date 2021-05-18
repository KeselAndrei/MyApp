package com.gmail.keseltms.myapp.Homework2

class Car(
    private var model: String,
    private var color: String = "black",
    private var engineVolume: Double,
    private var number: String = null ?: "Transit"
) {
    fun info(): String {
        return ("Model - $model, color - $color, engine volume -$engineVolume, number - $number")
    }
}