package com.gmail.keseltms.myapp.Homework2

internal class FactoryCar internal constructor() {
    private val car1: Car = Car(model = "Audi", color = "red", engineVolume = 2.0)
    private val car2: Car = Car("BMW", "blue", 2.5, "7777 AC-7")
    private val car3: Car = Car("Renault", "black", 1.8, "7798 AC-1")
    private val car4: Car = Car("Volvo", "purple", 3.0, "1111 AC-1")
    private val car5: Car = Car("Skoda", "black", 1.3, "7568 AC-5")
    private val car6: Car = Car(model = "Mercedes", color = "yellow", engineVolume = 1.8)

    fun getCars() {
        println(car1.info())
        println(car2.info())
        println(car3.info())
        println(car4.info())
        println(car5.info())
        println(car6.info())
    }
}