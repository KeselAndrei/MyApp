package com.gmail.keseltms.myapp.homework10

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CandyViewModel : ViewModel() {
    private val list: MutableList<Candy> = FactoryCandy.candyMaking()
    val liveData: MutableLiveData<MutableList<Candy>> = MutableLiveData()

    fun getCandyFromFactory() {
        liveData.value = list
    }
}