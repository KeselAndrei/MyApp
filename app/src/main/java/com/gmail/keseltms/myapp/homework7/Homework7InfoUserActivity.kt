package com.gmail.keseltms.myapp.homework7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
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
        Glide
            .with(this)
            .load(
                "data:image/png;base64,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"
            )
            .into(binding.ivProfile)

        binding.btnClose.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }
}