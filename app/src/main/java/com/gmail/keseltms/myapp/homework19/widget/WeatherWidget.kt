package com.gmail.keseltms.myapp.homework19.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.WidgetBinding
import com.gmail.keseltms.myapp.homework19.WeatherActivity

class WeatherWidget : AppWidgetProvider() {
    lateinit var binding: WidgetBinding
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        Log.e("KEK", "onUpdate")
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        val remoteViews = RemoteViews(context.packageName, R.layout.widget)

        remoteViews.setOnClickPendingIntent(R.id.tv_widget_temp, getSyncRequestIntent(context))
        remoteViews.setOnClickPendingIntent(R.id.widget_frame, getStartActivityIntent(context))

        appWidgetManager?.updateAppWidget(appWidgetIds, remoteViews)

        startSync(context)
    }

    override fun onReceive(context: Context, intent: Intent?) {

        binding = WidgetBinding.inflate(LayoutInflater.from(context))

        super.onReceive(context, intent)

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val remoteViews = RemoteViews(context.packageName, R.layout.widget)
        val componentWidget = ComponentName(context, WeatherWidget::class.java)

        when (intent?.action) {
            APP_WIDGET_SYNC_ACTION -> handleSyncRequest(context)
            APP_WIDGET_SYNC_RESULT -> handleSyncResult(remoteViews, intent, context)
            APP_WIDGET_OPEN_APP -> {
                context.startActivity(Intent(context, WeatherActivity::class.java))
            }
        }

        val ids = appWidgetManager.getAppWidgetIds(componentWidget)

        remoteViews.setOnClickPendingIntent(R.id.tv_widget_temp, getSyncRequestIntent(context))
        remoteViews.setOnClickPendingIntent(R.id.widget_frame, getStartActivityIntent(context))
        remoteViews.setOnClickPendingIntent(
            R.id.widget_frame,
            PendingIntent.getActivity(context, 0, Intent(context, WeatherActivity::class.java), 0)
        )

        appWidgetManager.updateAppWidget(ids, remoteViews)

    }


    private fun handleSyncRequest(context: Context) {

        startSync(context)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun handleSyncResult(remoteViews: RemoteViews, intent: Intent?, context: Context) {

        val id = intent?.getStringExtra(KEY_URL)
            ?.replace("[", "")
            ?.replace("]", "")

        val url = "https://openweathermap.org/img/wn/${id}@2x.png"

        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_meteocast_sun_and_cloud)
            .into(binding.ivIconID)

        remoteViews.setTextViewText(R.id.tv_widget_city, intent?.getStringExtra(KEY_CITY))
        remoteViews.setTextViewText(
            R.id.tv_widget_temp,
            (intent?.getIntExtra(KEY_TEMP, 0).toString())
        )
        remoteViews.setTextViewText(
            R.id.tv_widget_description, intent?.getStringExtra(
                KEY_DESCRIPTION
            )
        )
    }

    private fun getSyncRequestIntent(context: Context?): PendingIntent? {

        val intent = Intent(context, javaClass)
        intent.action = APP_WIDGET_SYNC_ACTION
        return PendingIntent.getBroadcast(context, 0, intent, 0)
    }

    private fun getStartActivityIntent(context: Context?): PendingIntent? {

        val intent = Intent(context, javaClass)
        intent.action = APP_WIDGET_OPEN_APP
        return PendingIntent.getBroadcast(context, 0, intent, 0)
    }

    private fun startSync(context: Context) {

        val intent = Intent(context, UpdateWidgetService::class.java)
        intent.action = APP_WIDGET_SYNC_ACTION
        context.startService(intent)
    }

    companion object {

        const val APP_WIDGET_OPEN_APP = "WIDGET_OPEN_APP"
        const val APP_WIDGET_SYNC_ACTION = "WIDGET_SYNC_ACTION"
        const val APP_WIDGET_SYNC_RESULT = "WIDGET_SYNC_RESULT"

        const val KEY_CITY = "WIDGET_CITY_NAME"
        const val KEY_TEMP = "WIDGET_KEY_TEMP"
        const val KEY_DESCRIPTION = "WIDGET_KEY_DESCRIPTION"
        const val KEY_URL = "KEY_URL"
    }
}