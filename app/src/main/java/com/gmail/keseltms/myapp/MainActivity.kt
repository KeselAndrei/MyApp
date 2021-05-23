package com.gmail.keseltms.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.keseltms.myapp.Homework2.FactoryCarSingleton
import com.gmail.keseltms.myapp.Homework3.Dog
import com.gmail.keseltms.myapp.Homework3.Elephant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FactoryCarSingleton.printCars()

        val dogBobbi = Dog("Bobbi", 22.2)
        println(
            "${dogBobbi.name} пробежал за ${
                String.format("%.4f", dogBobbi.getTime())
            } часа"
        )

        val elephantTom = Elephant("Tom", 11.1)
        println(
            "${elephantTom.name} пробежал за ${
                String.format("%.4f", elephantTom.getTime())
            } часа"
        )
    }
}