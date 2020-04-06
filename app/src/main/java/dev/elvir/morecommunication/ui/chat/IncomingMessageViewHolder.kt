package dev.elvir.morecommunication.ui.chat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.data.entity.message.Message
import kotlinx.android.synthetic.main.list_item_incoming_massage.view.*

class IncomingMessageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(message: Message) {
        val text = view.tv_incoming_message
        text.text = message.text
    }

}