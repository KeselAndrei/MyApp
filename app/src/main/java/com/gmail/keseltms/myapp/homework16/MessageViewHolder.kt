package com.gmail.keseltms.myapp.homework16

import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemMessageBinding

class MessageViewHolder(
    private val bindingView: ItemMessageBinding,
    private val messageClickListener: (Message) -> Unit
) : RecyclerView.ViewHolder(bindingView.root) {
    fun bind(item: Message) {
        itemView.setOnLongClickListener {
            messageClickListener(item)
            return@setOnLongClickListener true
        }
        bindingView.tvMessage.text = item.message
        bindingView.tvTime.text = item.time.toString()
    }
}