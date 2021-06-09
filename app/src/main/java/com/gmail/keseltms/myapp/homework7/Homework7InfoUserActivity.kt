package com.gmail.keseltms.myapp.homework7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.databinding.ActivityHomework7InfoUserBinding
import com.gmail.keseltms.myapp.homework7.Homework7CheckUserActivity.Companion.NAME
import com.gmail.keseltms.myapp.homework7.Homework7CheckUserActivity.Companion.PASSWORD
import kotlin.system.exitProcess

class Homework7InfoUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomework7InfoUserBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7InfoUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.extras?.getString(NAME)
        val password = intent.extras?.getString(PASSWORD)
        binding.apply {
            tvNameInfo.text = "Name: $name"
            tvPasswordExtras.text = "Password: $password"
        }
        binding.btnClose.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }
}