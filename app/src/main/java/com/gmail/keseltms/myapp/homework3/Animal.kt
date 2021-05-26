package com.gmail.keseltms.myapp.homework3

open class Animal(
    private var speed: Double
) {

    companion object {
        const val DISTANCE_IN_METERS: Int = 1080
    }

    fun getTime(): Double {
        return (DISTANCE_IN_METERS / speed) / 3600
    }
}