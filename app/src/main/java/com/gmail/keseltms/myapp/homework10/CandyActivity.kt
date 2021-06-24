package com.gmail.keseltms.myapp.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.keseltms.myapp.databinding.ActivityCandyBinding

class CandyActivity : AppCompatActivity() {

    private var list: MutableList<Candy> = mutableListOf()
    private lateinit var binding: ActivityCandyBinding
    private val candyViewModel: CandyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val candyAdapter = CandyAdapter(list)
        with(binding.rvCandy) {
            layoutManager = LinearLayoutManager(
                this@CandyActivity, LinearLayoutManager.VERTICAL, false
            )
            adapter = candyAdapter
        }

        candyViewModel.liveData.observe(this@CandyActivity, {
            candyAdapter.update(it)
        })
    }
}