package com.gmail.keseltms.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.databinding.ActivityMainBinding
import com.gmail.keseltms.myapp.homework10.CandyActivity
import com.gmail.keseltms.myapp.homework12.HomeworkFragmentActivity
import com.gmail.keseltms.myapp.homework13.CandyStoreActivity
import com.gmail.keseltms.myapp.homework16.MessengerActivity
import com.gmail.keseltms.myapp.homework17.CurrencyActivity
import com.gmail.keseltms.myapp.homework18.AlarmClockActivity
import com.gmail.keseltms.myapp.homework6.Homework6Activity
import com.gmail.keseltms.myapp.homework7.Homework7CheckUserActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnHomework6.setOnClickListener(clickListener)
            btnHomework7.setOnClickListener(clickListener)
            btnHomework10.setOnClickListener(clickListener)
            btnHomework12.setOnClickListener(clickListener)
            btnHomework13.setOnClickListener(clickListener)
            btnHomework16.setOnClickListener(clickListener)
            btnHomework17.setOnClickListener(clickListener)
            btnHomework18.setOnClickListener(clickListener)
            btnExit.setOnClickListener(clickListener)
        }
    }

    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view?.id) {
            R.id.btn_homework6 -> {
                startActivity(Intent(this, Homework6Activity::class.java))
            }
            R.id.btn_homework7 -> {
                startActivity(Intent(this, Homework7CheckUserActivity::class.java))
            }
            R.id.btn_homework10 -> {
                startActivity(Intent(this, CandyActivity::class.java))
            }
            R.id.btn_homework12 -> {
                startActivity(Intent(this, HomeworkFragmentActivity::class.java))
            }
            R.id.btn_homework13 -> {
                startActivity(Intent(this, CandyStoreActivity::class.java))
            }
            R.id.btn_homework16 -> {
                startActivity(Intent(this, MessengerActivity::class.java))
            }
            R.id.btn_homework17 -> {
                startActivity(Intent(this, CurrencyActivity::class.java))
            }
            R.id.btn_homework18 -> {
                startActivity(Intent(this, AlarmClockActivity::class.java))
            }
            R.id.btn_exit -> {
                this.finish()
            }
        }
    }
}