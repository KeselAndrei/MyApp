package com.gmail.keseltms.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.homework6.Homework6Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.text2)
        textView.setOnClickListener {
            val intent = Intent(this, Homework6Activity::class.java)
            startActivity(intent)
        }
    }
}
