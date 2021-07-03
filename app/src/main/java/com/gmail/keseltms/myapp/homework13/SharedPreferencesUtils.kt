package com.gmail.keseltms.myapp.homework13

import android.content.SharedPreferences

object SharedPreferencesUtils {

    lateinit var sharedPrefs: SharedPreferences

    fun putStrings(key: String, value: String) {
        sharedPrefs.edit().putString(key, value).apply()
    }

    fun putLongs(key: String, value: Long) {
        sharedPrefs.edit().putLong(key, value).apply()
    }

    fun getStrings(key: String) = sharedPrefs.getString(key, SharedPrefsKeys.DEF_VALUE_BRAND)

    fun getLongs(key: String):Long = sharedPrefs.getLong(key, SharedPrefsKeys.DEF_VALUE_BARCODE)
}