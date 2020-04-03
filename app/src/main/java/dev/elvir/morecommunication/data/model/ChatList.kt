package dev.elvir.morecommunication.data.model

data class ChatList(
    var userList : MutableList<User>?,
    var messageList: MutableList<Message>?
)