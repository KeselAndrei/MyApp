package com.gmail.keseltms.myapp

import android.app.Application
import androidx.room.Room
import com.gmail.keseltms.myapp.homework13.SharedPreferencesUtils
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys
import com.gmail.keseltms.myapp.homework16.MessageDao
import com.gmail.keseltms.myapp.homework16.MessageDatabase
import com.gmail.keseltms.myapp.homework17.restCurrency.models.CurrencyViewModel
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyApi
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import org.koin.dsl.module

@KoinApiExtension
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

        startKoin {
            androidContext(this@MySuperApp)
            modules(listOf(viewModels, currencyRepository, currencyApi))
        }
    }

    private val viewModels = module {
        viewModel { CurrencyViewModel(get()) }
    }

    private val currencyRepository = module {
        factory { CurrencyRepository(get()) }
    }

    private val currencyApi = module {
        single { CurrencyApi.get() }
    }
}