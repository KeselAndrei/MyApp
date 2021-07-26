package com.gmail.keseltms.myapp.homework18

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.gmail.keseltms.myapp.homework18.AlarmReceiver.Companion.ACTION_POSTPONE
import org.koin.android.ext.android.inject
import java.util.*


class AlarmService : Service() {
    private val alarmManager: AlarmManager by inject()
    private var alarmDate: Calendar = Calendar.getInstance().apply { time = Date() }

    override fun onBind(intent: Intent?): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        when (intent.action) {
            ACTION_POSTPONE -> {
                val intent = Intent(applicationContext, AlarmClockActivity::class.java)
                PendingIntent.getActivity(
                    applicationContext,
                    0,
                    intent,
                    0
                ).send()
                notificationManager.cancel(0)
            }
            AlarmReceiver.ACTION_DELETE -> {
                Toast.makeText(applicationContext, "Будильник oтменен", Toast.LENGTH_SHORT).show()
                notificationManager.cancel(0)
            }
        }
        stopSelf()
        return START_NOT_STICKY
    }
}