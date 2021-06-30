package com.gmail.keseltms.myapp.homework13

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.keseltms.myapp.homework10.Candy
import com.gmail.keseltms.myapp.homework10.FactoryCandy

class BarcodeViewModel : ViewModel() {

    val liveData: MutableLiveData<MutableList<Candy>> = MutableLiveData()

    init {
        getBarcodeFromCandyFactory()
    }

    private fun getBarcodeFromCandyFactory() {
        liveData.value = FactoryCandy.candyMaking()

    }
}