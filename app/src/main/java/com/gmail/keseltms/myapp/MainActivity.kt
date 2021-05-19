package com.gmail.keseltms.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.keseltms.myapp.Homework2.FactoryCarSingleton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FactoryCarSingleton.printCars()
        FactoryCarSingleton.car1.color = "purple"
        FactoryCarSingleton.car2.number = "2222 AA-2"
        FactoryCarSingleton.car3.number = "3333 AA-3"
        FactoryCarSingleton.car4.color = "pink"
        FactoryCarSingleton.car5.number = "5555 AA-5"
        FactoryCarSingleton.car6.number = "6666 AA-6"
        FactoryCarSingleton.printCars()
    }
}