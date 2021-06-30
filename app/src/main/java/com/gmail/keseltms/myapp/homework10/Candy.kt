package com.gmail.keseltms.myapp.homework10

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Candy(
    val brand: String,
    val barcodeNumber: Long
) : Parcelable