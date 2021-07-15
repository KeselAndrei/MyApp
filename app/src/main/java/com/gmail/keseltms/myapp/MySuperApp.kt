package com.gmail.keseltms.myapp.homework13

import android.app.Application
import androidx.room.Room
import com.gmail.keseltms.myapp.homework16.MessageDao
import com.gmail.keseltms.myapp.homework16.MessageDatabase
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyRepository
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyService

class MySuperApp : Application() {

    val currencyRepository: CurrencyRepository by lazy {
        CurrencyRepository(CurrencyService.getCurrencyService())
    }

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