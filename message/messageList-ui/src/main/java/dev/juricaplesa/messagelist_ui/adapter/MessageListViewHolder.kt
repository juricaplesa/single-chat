package dev.juricaplesa.messagelist_ui.adapter

import androidx.recyclerview.widget.RecyclerView
import dev.juricaplesa.messagelist_ui.databinding.ItemSentMessageBinding
import dev.juricaplesa.messagelist_ui.model.MessageUI

class MessageListViewHolder(
    private val binding: ItemSentMessageBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun setMessage(message: MessageUI) {
        binding.content.text = message.content
    }

}