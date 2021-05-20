package com.gmail.keseltms.myapp.Homework2

class Car(
    private val model: String,
    var color: String = "black",
    private val engineVolume: Double,
    var number: String? = "Transit"
) {
    fun info(): String {
        return "Model - $model, color - $color, engine volume -$engineVolume, number - $number"
    }
}