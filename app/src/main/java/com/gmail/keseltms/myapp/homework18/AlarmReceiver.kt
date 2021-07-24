package com.gmail.keseltms.myapp.homework18

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.core.app.NotificationCompat
import com.gmail.keseltms.myapp.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.startService(
            Intent(context, AlarmReceiver::class.java)
                .putExtra(
                    SOUND_KEY,
                    intent.getBooleanExtra(SOUND_KEY, false)
                )
        )
        onStartCommand(context, intent)
    }

    @SuppressLint("RestrictedApi", "WrongConstant")
    fun onStartCommand(context: Context, intent: Intent) {

        if (intent.getBooleanExtra(SOUND_KEY, false)) {
            MediaPlayer.create(context, R.raw.htc_basic).start()
        }

        val notificationBuilder =
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                .setContentTitle(context.getString(R.string.alarm))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentText(context.getString(R.string.content_text_alarm))

        val notificationIntent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        notificationBuilder.setContentIntent(pendingIntent)

        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val descriptionText = DESCRIPTION
            val channel = NotificationChannel(
                CHANNEL_ID,
                NOTIFICATION_CHANNEL,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notificationBuilder.build())

    }

    companion object {
        const val DESCRIPTION = "DESCRIPTION_TEXT"
        const val SOUND_KEY = "ALARM_SOUND_KEY"
        const val CHANNEL_ID = "CHANNEL_ID"
        const val NOTIFICATION_CHANNEL = "NOTIFICATION_CHANNEL"
    }
}