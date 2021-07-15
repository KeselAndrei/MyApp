package com.gmail.keseltms.myapp.homework17.restCurrency.restApi

import com.gmail.keseltms.myapp.homework17.restCurrency.data.Currency

class CurrencyRepository(
    private val currencyApi: CurrencyApi
) {

    suspend fun getCurrenciesLimitList(limit: Int): List<Currency> =
        currencyApi.getCurrencyLimitList(limit).data.map {
            Currency(id = it.id, name = it.name, symbol = it.symbol)
        }

    suspend fun getCurrenciesSortNameList(): List<Currency> =
        currencyApi.getCurrencySortNameList().data.map {
            Currency(id = it.id, name = it.name, symbol = it.symbol)
        }

    suspend fun getCurrenciesSortNameAndLimitList(limit: Int): List<Currency> =
        currencyApi.getCurrencySortNameAndLimitList(limit).data.map {
            Currency(id = it.id, name = it.name, symbol = it.symbol)
        }
}