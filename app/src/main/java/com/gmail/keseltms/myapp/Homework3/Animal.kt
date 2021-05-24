package com.gmail.keseltms.myapp.Homework3

open class Animal(
    private var speed: Double
) {

    companion object {
        const val DISTANCE: Int = 1080
    }

    fun getTime(): Double {
        return (DISTANCE / speed) / 3600
    }
}