package com.gmail.keseltms.myapp.homework2

object FactoryCarSingleton {

    fun printCars() {
        val car1 = Car(model = "Audi", color = "red", engineVolume = 2.0)
        val car2 = Car("BMW", "blue", 2.5, "7777 AC-7")
        val car3 = Car(model = "Renault", engineVolume = 1.8, number = "7798 AC-1")
        val car4 = Car("Volvo", "purple", 3.0, "1111 AC-1")
        val car5 = Car("Skoda", "pink", 1.3, "7568 AC-5")
        val car6 = Car(model = "Mercedes", color = "yellow", engineVolume = 1.8)
        println(car1.info())
        println(car2.info())
        println(car3.info())
        println(car4.info())
        println(car5.info())
        println(car6.info())
    }
}