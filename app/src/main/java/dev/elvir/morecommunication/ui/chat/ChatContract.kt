package dev.elvir.morecommunication.ui.chat

import dev.elvir.morecommunication.data.entity.user.UserEntity

interface ChatContract {

    interface View{

        fun addMessage(text : String)

    }

    interface Presenter{

        fun sendMessage(message: String)
        fun createRoomAndSendMessage(userEntity: UserEntity, toString: String)

    }

}