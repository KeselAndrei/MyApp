package com.gmail.keseltms.myapp.homework13

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemBarcodeBinding
import com.gmail.keseltms.myapp.homework10.Candy

class BarcodeAdapter(
    private val barcodeClickListener: () -> Unit,
    private val barcodeList: MutableList<Candy> = mutableListOf()
) : RecyclerView.Adapter<BarcodeViewHolder>() {

    override fun getItemCount(): Int = barcodeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarcodeViewHolder =
        BarcodeViewHolder(
            ItemBarcodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ),
            barcodeClickListener
        )

    override fun onBindViewHolder(holder: BarcodeViewHolder, position: Int) {
        holder.bind(barcodeList[position])
    }

    fun update(newListCandy: List<Candy>) {
        barcodeList.clear()
        barcodeList.addAll(newListCandy)
        notifyDataSetChanged()
    }
}