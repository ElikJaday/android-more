package dev.elvir.morecommunication.data.entity.message

import androidx.room.Ignore

class Message(
    var text: String="",
    var uidFrom: Long=0,
    var uidTo: Long=0,
    var msgUid: Long=0,
    @Ignore
    val messageType: MessageType = MessageType.OUTCOMING
)


enum class MessageType {
    INCOMING, OUTCOMING
}