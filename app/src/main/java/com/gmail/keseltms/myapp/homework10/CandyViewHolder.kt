package com.gmail.keseltms.myapp.homework10

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.R

class CandyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvBrand: TextView = itemView.findViewById(R.id.tv_brand)
    private val tvBarcodeNumber: TextView = itemView.findViewById(R.id.tv_barcode_number)
    fun bind(item: Candy) {
        tvBrand.text = item.brand
        tvBarcodeNumber.text = item.barcodeNumber.toString()
    }
}