package com.gmail.keseltms.myapp.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.keseltms.myapp.databinding.ActivityCandyBinding

class CandyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCandyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val candyAdapter = CandyAdapter(FactoryCandy.candyMaking())
        binding.rvCandy.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCandy.adapter = candyAdapter
    }
}