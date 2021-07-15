package com.gmail.keseltms.myapp.homework17.restCurrency.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gmail.keseltms.myapp.homework17.restCurrency.data.Currency
import com.gmail.keseltms.myapp.homework17.restCurrency.restApi.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyViewModel(
    private val currencyRepository: CurrencyRepository,
) : ViewModel() {

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

class CurrentViewModelFactory(
    private val currencyRepository: CurrencyRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrencyViewModel(currencyRepository) as T
    }
}