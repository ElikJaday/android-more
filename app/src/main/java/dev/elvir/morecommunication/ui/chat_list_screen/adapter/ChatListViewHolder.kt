package dev.elvir.morecommunication.ui.chat_list_screen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.data.entity.chat.Chat
import kotlinx.android.synthetic.main.list_item_chat_list.view.*


class ChatListViewHolder(
    val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        chat: Chat,
        callback: ChatListAdapter.Callback
    ) {
        val text = view.tv_user_name
        text.text = chat.chatId.toString()
        view.vg_item_chat_list.setOnClickListener {
            callback.selectedItem(chat)
        }
    }
}