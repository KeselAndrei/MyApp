package com.gmail.keseltms.myapp.homework7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.ActivityHomework7CheckUserBinding

@Suppress("DEPRECATION")
class Homework7CheckUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomework7CheckUserBinding
    private var counter = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7CheckUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.let {
            counter = it.getInt(COUNTER_KEY)
        }
        var count = 0
        binding.btnStart.setOnClickListener {
            when (counter) {
                in 1..10 -> {
                    binding.tvTimer.text = (counter - 1).toString()
                    counter--
                }
                0 -> {
                    binding.apply {
                        tvTimer.visibility = View.GONE
                        editEnterName.visibility = View.VISIBLE
                        editEnterPassword.visibility = View.VISIBLE
                        btnStart.apply {
                            text = getString(R.string.btn_homework_7_user_enter)
                            visibility = View.VISIBLE
                            counter = -1
                        }
                    }

                }
                else -> {
                    if (binding.editEnterName.text!!.isEmpty() || binding.editEnterPassword.text!!.isEmpty()) {
                        if (count < 2) {
                            binding.tvTimer.apply {
                                setTextColor(resources.getColor(R.color.red))
                                textSize = 20f
                                text = getText(R.string.btn_homework_7_password_invalid)
                                visibility = View.VISIBLE
                                count++
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
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvTimer.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_KEY, counter)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val NAME = "name"
        const val PASSWORD = "password"
        const val COUNTER_KEY = "CounterKey"
    }
}