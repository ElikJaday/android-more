package dev.elvir.morecommunication.data.entity.message

data class Message(
    var text: String,
    val uidFrom: Long,
    val uidTo: Long,
    val msgUid: Long,
    val messageType: MessageType
)


enum class MessageType {
    INCOMING, OUTCOMING
}