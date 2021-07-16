package com.gmail.keseltms.myapp.homework10

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Candy (
    val brand: String,
    val barcodeNumber: Long
) : Parcelable