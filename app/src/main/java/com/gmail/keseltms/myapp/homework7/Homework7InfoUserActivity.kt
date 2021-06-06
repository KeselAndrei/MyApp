package com.gmail.keseltms.myapp.homework7

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.R

class Homework7InfoUserActivity : AppCompatActivity() {
    private lateinit var tvInfoName: TextView
    private lateinit var tvInfoPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework7_info_user)
        tvInfoName = findViewById(R.id.tv_info_name)
        tvInfoPassword = findViewById(R.id.tv_info_password)
        val name = intent.extras?.getString("name")
        val password = intent.extras?.getString("password")
        tvInfoName.text = name
        tvInfoPassword.text = password
    }
}