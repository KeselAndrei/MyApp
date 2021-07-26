package com.gmail.keseltms.myapp.homework19.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.keseltms.myapp.homework19.data.WeatherResult
import com.gmail.keseltms.myapp.homework19.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class WeatherViewModel(
    private val apiRepository: ApiRepository
) : ViewModel() {

    val liveData: MutableLiveData<WeatherResult> = MutableLiveData()

    init {
        getResultWeather()
    }

    private fun getResultWeather() {
        try {
            viewModelScope.launch {
                val result = withContext(Dispatchers.IO) {
                    apiRepository.getApiResult()
                }
                liveData.postValue(result)
            }

        } catch (e: Exception) {
            print(e)
        }
    }
}