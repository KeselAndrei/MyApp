package com.gmail.keseltms.myapp

import android.app.AlarmManager
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.gmail.keseltms.myapp.homework13.SharedPreferencesUtils
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys
import com.gmail.keseltms.myapp.homework16.MessageDao
import com.gmail.keseltms.myapp.homework16.MessageDatabase
import com.gmail.keseltms.myapp.homework17.restCurrency.models.CurrencyViewModel
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyApi
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyRepository
import com.gmail.keseltms.myapp.homework19.cloud.WeatherApi
import com.gmail.keseltms.myapp.homework19.repository.ApiRepository
import com.gmail.keseltms.myapp.homework19.viewModel.WeatherViewModel
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
            modules(listOf(viewModels, repository, api,systemModule))
        }
    }

    private val viewModels = module {
        viewModel { CurrencyViewModel(get()) }
        viewModel { WeatherViewModel(get()) }
    }

    private val repository = module {
        factory { CurrencyRepository(get())}
        factory { ApiRepository(get()) }
    }

    private val api = module {
        single { CurrencyApi.get() }
        single { WeatherApi.get() }
    }

    private val systemModule = module {
        factory { get<Context>().getSystemService(ALARM_SERVICE) as AlarmManager }
    }
}