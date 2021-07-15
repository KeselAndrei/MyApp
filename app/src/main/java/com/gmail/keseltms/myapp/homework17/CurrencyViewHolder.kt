package com.gmail.keseltms.myapp.homework17

import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemCurrencyBinding
import com.gmail.keseltms.myapp.homework17.restCurrency.data.Currency

class CurrencyViewHolder(
    private val bindingView: ItemCurrencyBinding
) : RecyclerView.ViewHolder(bindingView.root) {

    fun bind(item: Currency) {
        bindingView.tvId.text = item.id.toString()
        bindingView.tvName.text = item.name
        bindingView.tvSymbol.text = item.symbol
    }
}