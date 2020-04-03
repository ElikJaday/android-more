package dev.elvir.morecommunication.ui.chat_list_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_chat_list.view.*


class ChatListViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val userName = view.tv_user_name
}