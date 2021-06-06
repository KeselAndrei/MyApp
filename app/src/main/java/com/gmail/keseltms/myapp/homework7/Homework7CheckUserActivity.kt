package com.gmail.keseltms.myapp.homework7

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.R

@Suppress("DEPRECATION")
class Homework7CheckUserActivity : AppCompatActivity() {
    private lateinit var btnStart: Button
    private lateinit var tvTimer: TextView
    private lateinit var editEnterName: TextView
    private lateinit var editEnterPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework7_check_user)
        btnStart = findViewById(R.id.btn_start)
        tvTimer = findViewById(R.id.tv_timer)
        editEnterName = findViewById(R.id.tv_enter_name)
        editEnterPassword = findViewById(R.id.tv_enter_password)
        btnStart.setOnClickListener {
            btnStart.visibility = View.INVISIBLE
            object : CountDownTimer(11000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    tvTimer.textSize = 200f
                    tvTimer.text = "${millisUntilFinished / 1000}"
                }

                override fun onFinish() {
                    tvTimer.visibility = View.GONE
                    editEnterName.visibility = View.VISIBLE
                    editEnterPassword.visibility = View.VISIBLE
                    btnStart.text = getString(R.string.btn_homework_7_user_enter)
                    btnStart.visibility = View.VISIBLE
                }
            }.start()
            var count = 0
            btnStart.setOnClickListener {
                if (editEnterName.text.isEmpty() || editEnterPassword.text.isEmpty()) {
                    if (count < 2) {
                        tvTimer.setTextColor(resources.getColor(R.color.red))
                        tvTimer.textSize = 20f
                        tvTimer.text = getText(R.string.btn_homework_7_password_invalid)
                        tvTimer.visibility = View.VISIBLE
                        count += 1
                    } else {
                        startActivity(Intent(this, Homework7CheckUserActivity::class.java))
                    }
                } else {
                    startActivity(Intent(this, Homework7InfoUserActivity::class.java).apply {
                        putExtra("name", editEnterName.text.toString())
                        putExtra("password", editEnterPassword.text.toString())
                    })
                }
            }
        }
    }
}