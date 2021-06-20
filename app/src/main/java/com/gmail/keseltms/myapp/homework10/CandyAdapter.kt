package com.gmail.keseltms.myapp.homework10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.R

class CandyAdapter(
    private val candyList: List<Candy>
) : RecyclerView.Adapter<CandyViewHolder>() {

    override fun getItemCount(): Int = candyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_candy, parent, false)
        return CandyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CandyViewHolder, position: Int) {
        holder.bind(candyList[position])
    }
}