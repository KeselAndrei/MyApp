package com.gmail.keseltms.myapp.homework16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.keseltms.myapp.databinding.ItemMessageBinding

class MessageAdapter(
    private val messageClickListener: (Message) -> Unit,
    private val messageList: MutableList<Message> = mutableListOf(),

    ) : RecyclerView.Adapter<MessageViewHolder>() {

    override fun getItemCount(): Int = messageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {

        return MessageViewHolder(
            ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            messageClickListener
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    fun update(newMessageList: List<Message>) {
        messageList.clear()
        messageList.addAll(newMessageList)
        notifyDataSetChanged()
    }
}