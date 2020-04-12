package dev.elvir.morecommunication.ui.chat

import dev.elvir.morecommunication.data.entity.chat.Message

interface ChatContract {

    interface View {

        fun showMessage(message: Message)

    }

    interface Presenter {

        fun fetchMessage(chatId: Long)
        fun sendMessage(message: String, toUser: Long)

    }

}