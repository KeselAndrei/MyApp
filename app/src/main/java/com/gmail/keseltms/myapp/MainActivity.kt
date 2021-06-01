package com.gmail.keseltms.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.homework6.Homework6Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btn_homework6)
        btn.setOnClickListener {
            startActivity(Intent(this, Homework6Activity::class.java))
        }
    }
}
