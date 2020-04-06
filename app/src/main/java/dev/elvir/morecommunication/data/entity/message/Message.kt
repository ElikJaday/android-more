package dev.elvir.morecommunication.data.entity.message

data class Message (
    val text: String = "",
    val messageType: MessageType
)


enum class MessageType{
    INCOMING,OUTCOMING
}