package com.gmail.keseltms.myapp.homework7

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.ActivityHomework7CheckUserBinding

@Suppress("DEPRECATION")
class Homework7CheckUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomework7CheckUserBinding
    private var isChek: Boolean = true
    private var counter = 10
    private var countInvalidClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7CheckUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.let {
            counter = it.getInt(COUNTER_KEY)
        }

        binding.btnStart.setOnClickListener {
            if (isChek) startTimer()
            else enterNameAndPassword()
        }
    }

    override fun onResume() {
        super.onResume()
        when (counter) {
            0 -> {
                startTimer()
            }
            else -> {
                binding.tvTimer.text = counter.toString()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.apply {
            putInt(COUNTER_KEY, counter)
            super.onSaveInstanceState(outState)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun startTimer() {
        when (counter) {
            in 1..10 -> {
                binding.tvTimer.text = (counter - 1).toString()
                counter--
            }
            0 -> {
                binding.apply {
                    tvTimer.visibility = View.INVISIBLE
                    editEnterNameLayout.visibility = View.VISIBLE
                    editEnterPasswordLayout.visibility = View.VISIBLE
                    btnStart.apply {
                        text = getString(R.string.homework_7_user_enter)
                        visibility = View.VISIBLE
                        icon = resources.getDrawable(R.drawable.ic_baseline_how_to_reg_24)
                        isChek = false
                    }
                }
            }
        }
    }

    private fun enterNameAndPassword() {

        if (binding.editEnterName.text!!.isEmpty() || binding.editEnterPassword.text!!.isEmpty()) {
            if (countInvalidClick < 2) {
                binding.tvTimer.apply {
                    setTextColor(resources.getColor(R.color.red))
                    textSize = 20f
                    text = getText(R.string.homework_7_password_invalid)
                    visibility = View.VISIBLE
                    countInvalidClick++
                }
            } else {
                startActivity(Intent(this, Homework7CheckUserActivity::class.java))
            }
        } else {
            startActivity(
                Intent(
                    this,
                    Homework7InfoUserActivity::class.java
                ).apply {
                    putExtra(NAME, binding.editEnterName.text.toString())
                    putExtra(PASSWORD, binding.editEnterPassword.text.toString())
                })
        }
    }

    companion object {
        const val NAME = "name"
        const val PASSWORD = "password"
        const val COUNTER_KEY = "CounterKey"
    }
}