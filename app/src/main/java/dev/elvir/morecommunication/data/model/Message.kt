package dev.elvir.morecommunication.data.model

data class Message (
    val text: String = "",
    val messageType: MessageType
)


enum class MessageType{
    INCOMING,OUTCOMING
}