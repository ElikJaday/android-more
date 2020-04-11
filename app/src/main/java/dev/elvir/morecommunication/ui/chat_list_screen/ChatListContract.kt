package dev.elvir.morecommunication.ui.chat_list_screen

import dev.elvir.morecommunication.data.entity.chat.Chat

interface ChatListContract {

    interface View {

        fun showChatList(list: MutableList<Chat>)

    }

    interface Presenter {

        fun fetchData()

    }

}