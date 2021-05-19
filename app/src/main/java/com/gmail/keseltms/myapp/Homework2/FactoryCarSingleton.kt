package com.gmail.keseltms.myapp.Homework2

object FactoryCarSingleton {
    var car1: Car = Car(model = "Audi", color = "red", engineVolume = 2.0)
    var car2: Car = Car("BMW", "blue", 2.5, "7777 AC-7")
    var car3: Car = Car(model = "Renault", engineVolume = 1.8, number = "7798 AC-1")
    var car4: Car = Car("Volvo", "purple", 3.0, "1111 AC-1")
    var car5: Car = Car("Skoda", "pink", 1.3, "7568 AC-5")
    var car6: Car = Car(model = "Mercedes", color = "yellow", engineVolume = 1.8)

    fun printCars() {
        println(car1.info())
        println(car2.info())
        println(car3.info())
        println(car4.info())
        println(car5.info())
        println(car6.info())
    }
}