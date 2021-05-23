package com.gmail.keseltms.myapp.Homework3

open class Animal(
    private var speed: Double
) {

    companion object {
        const val distance: Int = 1080
    }

    fun getTime(): Double {
        return (distance / speed) / 3600
    }
}