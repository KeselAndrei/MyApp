package com.gmail.keseltms.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.homework6.Homework6Activity
import com.gmail.keseltms.myapp.homework7.Homework7CheckUserActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var btnHomework6: Button
    private lateinit var btnHomework7: Button
    private lateinit var btnExit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHomework6 = findViewById(R.id.btn_homework6)
        btnHomework7 = findViewById(R.id.btn_homework7)
        btnExit = findViewById(R.id.btn_exit)
        btnHomework6.setOnClickListener {
            startActivity(Intent(this, Homework6Activity::class.java))
        }
        btnHomework7.setOnClickListener {
            startActivity(Intent(this, Homework7CheckUserActivity::class.java))
        }
        btnExit.setOnClickListener {
            this.finish()
            exitProcess(0)
        }
    }
}