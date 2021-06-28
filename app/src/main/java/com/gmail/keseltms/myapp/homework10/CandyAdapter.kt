package com.gmail.keseltms.myapp.homework10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemCandyBinding

class CandyAdapter(
    private val candyList: MutableList<Candy> = mutableListOf()
) : RecyclerView.Adapter<CandyViewHolder>() {

    override fun getItemCount(): Int = candyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandyViewHolder =
        CandyViewHolder(
            ItemCandyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

    override fun onBindViewHolder(holder: CandyViewHolder, position: Int) {
        holder.bind(candyList[position])
    }

    fun update(newListCandy: List<Candy>) {
        candyList.clear()
        candyList.addAll(newListCandy)
        notifyDataSetChanged()
    }
}