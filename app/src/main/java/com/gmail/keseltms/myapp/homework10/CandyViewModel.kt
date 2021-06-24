package com.gmail.keseltms.myapp.homework10

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CandyViewModel : ViewModel() {

    val liveData: MutableLiveData<MutableList<Candy>> = MutableLiveData()

    init {
        getCandyFromFactory()
    }

    private fun getCandyFromFactory() {
        liveData.value = FactoryCandy.candyMaking()
    }
}