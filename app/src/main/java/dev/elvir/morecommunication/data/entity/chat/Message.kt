package dev.elvir.morecommunication.data.entity.chat

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Message(
    @PrimaryKey
    var msgUid: Long = 0,
    var chatLinkId: Long? = null,
    var text: String = "",
    var uidFrom: Long = 0,
    var uidTo: Long = 0,
    @Ignore
    val messageType: MessageType = MessageType.OUTCOMING
) : Parcelable


enum class MessageType {
    INCOMING, OUTCOMING
}