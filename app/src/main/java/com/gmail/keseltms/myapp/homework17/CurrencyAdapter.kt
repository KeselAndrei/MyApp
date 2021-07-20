package com.gmail.keseltms.myapp.homework17

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gmail.keseltms.myapp.databinding.ItemCurrencyBinding
import com.gmail.keseltms.myapp.homework17.restCurrency.data.Currency

class CurrencyAdapter : ListAdapter<Currency, CurrencyViewHolder>(DifUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =

        CurrencyViewHolder(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DifUtilItemCallback : DiffUtil.ItemCallback<Currency>() {

    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.id == newItem.id
                && oldItem.name == newItem.name
                && oldItem.symbol == newItem.symbol
    }
}
