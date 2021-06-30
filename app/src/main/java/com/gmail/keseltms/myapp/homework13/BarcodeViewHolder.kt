package com.gmail.keseltms.myapp.homework13

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemBarcodeBinding
import com.gmail.keseltms.myapp.homework10.Candy

class BarcodeViewHolder(
    private val bindingView: ItemBarcodeBinding,
    private val barcodeClickListener: () -> Unit
) : RecyclerView.ViewHolder(bindingView.root) {

    fun bind(item: Candy) {
        itemView.setOnClickListener {
            val bundle = Bundle()
            val infoFragment = InfoCandyFragment()
            bundle.putSerializable(BRAND,item)
            infoFragment.arguments = bundle
            barcodeClickListener()
        }

        bindingView.tvBarcode.text = item.barcodeNumber.toString()
    }

    companion object {
        const val BRAND = "BRAND"
    }
}