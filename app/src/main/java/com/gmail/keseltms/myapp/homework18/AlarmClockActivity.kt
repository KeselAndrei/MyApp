package com.gmail.keseltms.myapp.homework18

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.ActivityAlarmClockBinding
import org.koin.android.ext.android.inject
import java.util.*

class AlarmClockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmClockBinding
    private var alarmDate: Calendar = Calendar.getInstance().apply { time = Date() }
    private val alarmManager: AlarmManager by inject()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmClockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timePicker.setIs24HourView(true)
        binding.timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            alarmDate.set(Calendar.HOUR_OF_DAY, hourOfDay)
            alarmDate.set(Calendar.MINUTE, minute)
        }

        binding.confirm.setOnClickListener {
            with(binding.datePicker) {
                alarmDate.set(Calendar.YEAR, year)
                alarmDate.set(Calendar.MONTH, month)
                alarmDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }

            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                alarmDate.timeInMillis,
                PendingIntent.getBroadcast(
                    this,
                    0,
                    Intent(applicationContext, AlarmReceiver::class.java).apply {
                        putExtra(AlarmReceiver.SOUND_KEY, true)
                    }, PendingIntent.FLAG_UPDATE_CURRENT

                )
            )
            Toast.makeText(this, getString(R.string.add_new_alarm), Toast.LENGTH_SHORT).show()

        }
    }
}