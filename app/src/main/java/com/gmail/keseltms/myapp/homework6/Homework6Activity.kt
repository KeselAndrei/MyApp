package com.gmail.keseltms.myapp.homework6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.MainActivity
import com.gmail.keseltms.myapp.R

class Homework6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework6)
        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}