package dev.juricaplesa.messagelist_ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.juricaplesa.messagelist_ui.databinding.ItemSentMessageBinding
import dev.juricaplesa.messagelist_ui.model.MessageUI

class MessageListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messages: ArrayList<MessageUI> = ArrayList()

    fun addPreviousData(data: List<MessageUI>) {
        messages.addAll(data)
        notifyItemRangeInserted(messages.size, data.size)
    }

    fun addNewData(data: MessageUI) {
        messages.add(0, data)
        notifyItemRangeInserted(0, 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSentMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MessageListViewHolder -> {
                holder.setMessage(messages[position])
            }
        }
    }

    override fun getItemCount() = messages.size

}