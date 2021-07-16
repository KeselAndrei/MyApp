package com.gmail.keseltms.myapp.homework17

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.ActivityCurrencyBinding
import com.gmail.keseltms.myapp.homework17.restCurrency.models.CurrencyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrencyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCurrencyBinding

    private val viewModel: CurrencyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCurrencyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val currencyAdapter = CurrencyAdapter()
        with(binding.rvCurrency) {
            layoutManager = LinearLayoutManager(
                this@CurrencyActivity, LinearLayoutManager.VERTICAL, false
            )
            adapter = currencyAdapter
        }

        binding.btnStart.setOnClickListener {

            isChekUserChoose()
        }

        viewModel.liveData.observe(this@CurrencyActivity, {
            currencyAdapter.update(it)
        })
    }

    private fun isChekUserChoose() {

        if (binding.cbName.isChecked && binding.editCount.text.isNullOrEmpty()) {
            viewModel.onUserSortName()
        } else if (binding.cbName.isChecked &&
            !binding.editCount.text.isNullOrEmpty() &&
            binding.editCount.text.toString().toInt() != 0
        ) {
            val limit: String = binding.editCount.text.toString()
            viewModel.onUserSortNameAndLimit(limit.toInt())
            binding.editCount.text = null
        } else if (!binding.editCount.text.isNullOrEmpty() &&
            binding.editCount.text.toString().toInt() != 0 &&
            !binding.cbName.isChecked
        ) {
            val limit: String = binding.editCount.text.toString()
            viewModel.onUserLimit(limit.toInt())
            binding.editCount.text = null
        } else {
            Toast.makeText(
                this, getString(R.string.currency_info_message),
                Toast.LENGTH_SHORT
            ).show()
            binding.editCount.text = null
        }
    }
}