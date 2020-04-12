package dev.elvir.morecommunication.ui.chat.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.data.entity.chat.Message
import kotlinx.android.synthetic.main.list_item_outcoming_massage.view.*

class OutcomingMessageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(message: Message) {
        val text = view.tv_outcoming_message
        text.text = message.text
    }

}