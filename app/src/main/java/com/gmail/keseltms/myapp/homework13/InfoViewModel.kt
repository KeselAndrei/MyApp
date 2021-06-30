//package com.gmail.keseltms.myapp.homework13
//
//import android.os.Bundle
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.gmail.keseltms.myapp.homework10.Candy
//
//class InfoViewModel : ViewModel() {
//    private val bundle = Bundle()
//    val liveData: MutableLiveData<Candy> = MutableLiveData()
//
//    init {
//
//        getCandyFromCandyFactory()
//    }
//
//    private fun getCandyFromCandyFactory() {
//        liveData.value = bundle.getSerializable(BarcodeViewHolder.BRAND) as Candy?
//    }
//}