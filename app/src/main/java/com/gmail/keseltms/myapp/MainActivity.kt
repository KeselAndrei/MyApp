package com.gmail.keseltms.myapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.databinding.ActivityMainBinding
import com.gmail.keseltms.myapp.homework6.Homework6Activity
import com.gmail.keseltms.myapp.homework7.Homework7CheckUserActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHomework6.setOnClickListener {
            startActivity(Intent(this, Homework6Activity::class.java))
        }
        binding.btnHomework7.setOnClickListener {
            startActivity(Intent(this, Homework7CheckUserActivity::class.java))
        }
        binding.btnExit.setOnClickListener {
            this.finish()
            exitProcess(0)
        }
    }
}