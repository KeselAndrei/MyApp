package com.gmail.keseltms.myapp.homework13

import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemBarcodeBinding
import com.gmail.keseltms.myapp.homework10.Candy

class BarcodeViewHolder(
    private val bindingView: ItemBarcodeBinding
) : RecyclerView.ViewHolder(bindingView.root) {

    fun bind(item: Candy) {
        itemView.setOnClickListener {
            CandyStoreActivity().barcodeClickListener(item)
        }
        bindingView.tvBarcode.text = item.barcodeNumber.toString()
    }
}