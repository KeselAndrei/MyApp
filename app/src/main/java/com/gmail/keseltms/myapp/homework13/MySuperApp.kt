package com.gmail.keseltms.myapp.homework13

import android.app.Application
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_KEY

class MySuperApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPreferencesUtils.sharedPrefs = applicationContext.getSharedPreferences(
            PREFS_KEY,
            MODE_PRIVATE
        )
    }
}