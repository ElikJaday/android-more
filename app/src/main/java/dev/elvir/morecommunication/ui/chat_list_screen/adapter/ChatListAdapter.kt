package dev.elvir.morecommunication.ui.chat_list_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.ext.autoNotify
import kotlin.properties.Delegates

class ChatListAdapter(
    val callback: Callback
) : RecyclerView.Adapter<ChatListViewHolder>() {

    var list: List<Chat> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.chatId == n.chatId }
    }

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