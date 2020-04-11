package dev.elvir.morecommunication.ui.chat_list_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.chat.Chat

class ChatListAdapter(
    val list: MutableList<Chat>,
    val callback: Callback
) : RecyclerView.Adapter<ChatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder =
        ChatListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_chat_list, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) =
        holder.bind(list[position], callback)

    interface Callback {

        fun selectedItem(chat: Chat)

    }

}