package dev.elvir.morecommunication.data.entity.chat

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import dev.elvir.morecommunication.data.entity.message.Message

@Entity
class Chat(
    @PrimaryKey(autoGenerate = false)
    var chatId: Long =0,
    @Embedded
    var lastMessage: Message
)