package com.gmail.keseltms.myapp.homework19.widget

import android.app.Service
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import com.gmail.keseltms.myapp.homework19.repository.ApiRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class UpdateWidgetService : Service() {

    private val apiRepository: ApiRepository by inject()

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        GlobalScope.launch {

            val city = apiRepository.getApiResult().name
            val temp = apiRepository.getApiResult().temp.toInt()
            val description = apiRepository.getApiResult().description
                .replace("[", "")
                .replace("]", "")
            val iconId = apiRepository.getApiResult().iconId
                .replace("[", "")
                .replace("]", "")

            updateWidget(city, temp, description, iconId)
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun updateWidget(city: String, temp: Int, description: String, iconId: String) {
        val intent = Intent(applicationContext, WeatherWidget::class.java)
        intent.action = WeatherWidget.APP_WIDGET_SYNC_RESULT
        intent.putExtra(WeatherWidget.KEY_CITY, city)
        intent.putExtra(WeatherWidget.KEY_TEMP, temp)
        intent.putExtra(WeatherWidget.KEY_DESCRIPTION, description)
        intent.putExtra(WeatherWidget.KEY_URL, iconId)

        val widgetManager = AppWidgetManager.getInstance(applicationContext)
        val ids = widgetManager.getAppWidgetIds(
            ComponentName(
                applicationContext,
                WeatherWidget::class.java
            )
        )
        widgetManager.notifyAppWidgetViewDataChanged(ids, android.R.id.list)
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
        applicationContext.sendBroadcast(intent)
    }
}