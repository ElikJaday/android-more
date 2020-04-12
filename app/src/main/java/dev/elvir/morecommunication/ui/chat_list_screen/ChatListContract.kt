package dev.elvir.morecommunication.ui.chat_list_screen

import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.ui.base.Presenter

interface ChatListContract {

    interface ChatListMvpView {

        fun showChatList(list: MutableList<Chat>)

    }

    interface ChatListMvpPresenter:Presenter<ChatListMvpView> {

        fun fetchData()

    }

}