package dev.elvir.morecommunication.ui.chat

import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.ui.base.Presenter

interface ChatContract {

    interface ChatMvpView {
        fun showMessage(list : MutableList<Message>)
    }

    interface ChatMvpPresenter:Presenter<ChatMvpView> {

        fun fetchMessage(chatId: Long)
        fun sendMessage(message: String, toUser: Long)

    }

}