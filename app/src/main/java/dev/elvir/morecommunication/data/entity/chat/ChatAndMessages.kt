package dev.elvir.morecommunication.data.entity.chat

import androidx.room.Embedded
import androidx.room.Relation

data class ChatAndMessages(
    @Embedded val chat : Chat,
    @Relation(parentColumn = "chatId", entityColumn = "chatLinkId")
    val listMessage : MutableList<Message>
)