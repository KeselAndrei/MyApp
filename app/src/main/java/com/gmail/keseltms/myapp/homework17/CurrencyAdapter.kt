package com.gmail.keseltms.myapp.homework17

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemCurrencyBinding
import com.gmail.keseltms.myapp.homework17.restCurrency.data.Currency

class CurrencyAdapter(
    private val currencyList: MutableList<Currency> = mutableListOf(),
) : RecyclerView.Adapter<CurrencyViewHolder>() {

    override fun getItemCount(): Int = currencyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =

        CurrencyViewHolder(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencyList[position])
    }

    fun update(newListCurrency: List<Currency>) {
        currencyList.clear()
        currencyList.addAll(newListCurrency)
        notifyDataSetChanged()
    }
}