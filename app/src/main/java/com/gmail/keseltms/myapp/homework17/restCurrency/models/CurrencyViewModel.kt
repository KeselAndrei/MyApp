package com.gmail.keseltms.myapp.homework17.restCurrency.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.keseltms.myapp.homework17.restCurrency.data.Currency
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
class CurrencyViewModel : ViewModel(), KoinComponent {

    private val currencyRepository: CurrencyRepository by inject()


    val liveData: MutableLiveData<List<Currency>> = MutableLiveData()

    fun onUserLimit(limit: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            val currencyList = withContext(Dispatchers.IO) {
                currencyRepository.getCurrenciesLimitList(limit)
            }
            liveData.value = currencyList
        }
    }

    fun onUserSortName() {
        viewModelScope.launch(Dispatchers.Main) {
            val currencySortNameList = withContext(Dispatchers.IO) {
                currencyRepository.getCurrenciesSortNameList()
            }
            liveData.value = currencySortNameList
        }
    }

    fun onUserSortNameAndLimit(limit: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            val currencySortNameAndLimitList = withContext(Dispatchers.IO) {
                currencyRepository.getCurrenciesSortNameAndLimitList(limit)
            }
            liveData.value = currencySortNameAndLimitList
        }
    }
}