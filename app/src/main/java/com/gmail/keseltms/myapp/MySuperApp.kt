package com.gmail.keseltms.myapp.homework13

import android.app.Application
import androidx.room.Room
import com.gmail.keseltms.myapp.homework16.MessageDao
import com.gmail.keseltms.myapp.homework16.MessageDatabase

class MySuperApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(
            applicationContext, MessageDatabase::class.java, "table_message"
        ).build()
    }

    val messageDao: MessageDao by lazy {
        messageDatabase.messageDao()
    }

    override fun onCreate() {
        super.onCreate()

        SharedPreferencesUtils.sharedPrefs = applicationContext.getSharedPreferences(
            SharedPrefsKeys.PREFS_KEY,
            MODE_PRIVATE
        )
    }
}