package dev.elvir.morecommunication.ui.chat

import dev.elvir.morecommunication.data.entity.user.UserEntity

interface ChatContract {

    interface View{


    }

    interface Presenter{

        fun sendMessage(message: String)
        fun createRoomAndSendMessage(userEntity: UserEntity, toString: String)

    }

}