package com.gmail.keseltms.myapp.homework6

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.MainActivity
import com.gmail.keseltms.myapp.R

class Homework6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework6)
        val textView: TextView = findViewById(R.id.textViewHomework6)
        textView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}