package com.gmail.keseltms.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.keseltms.myapp.Homework2.FactoryCarSingleton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FactoryCarSingleton.printCars()
    }
}