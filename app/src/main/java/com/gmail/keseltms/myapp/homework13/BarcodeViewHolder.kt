package com.gmail.keseltms.myapp.homework13

import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemBarcodeBinding
import com.gmail.keseltms.myapp.homework10.Candy
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_MESSAGE_BRAND_KEY
import com.gmail.keseltms.myapp.homework13.SharedPrefsKeys.PREFS_MESSAGE_BARCODE_KEY

class BarcodeViewHolder(
    private val bindingView: ItemBarcodeBinding,
    private val barcodeClickListener: (Candy) -> Unit
) : RecyclerView.ViewHolder(bindingView.root) {

    fun bind(item: Candy) {
        itemView.setOnClickListener {
            barcodeClickListener(item)
        }
        bindingView.tvBarcode.text = item.barcodeNumber.toString()
    }
}