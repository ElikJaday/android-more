package dev.elvir.morecommunication.data.entity.chat

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Message(
    @PrimaryKey
    var msgUid: Long = 0,
    @Expose(serialize = false, deserialize = false)
    var chatLinkId: Long? = null,
    var text: String = "",
    var uidFrom: Long = 0,
    var uidTo: Long = 0,
    @Expose(serialize = false, deserialize = false)
    @TypeConverters(MessageTypeConverter::class)
    var messageType: MessageType = MessageType.OUTCOMING,
    var serverTime : Long = 0
) : Parcelable


enum class MessageType(type: Int) {
    INCOMING(0), OUTCOMING(1)
}


class MessageTypeConverter() {

    @TypeConverter
    fun fromMessageType(value: MessageType): Int = value.ordinal

    @TypeConverter
    fun toMessageType(value: Int): MessageType {
        return when (value) {
            0 -> MessageType.INCOMING
            1 -> MessageType.OUTCOMING
            else -> MessageType.OUTCOMING
        }
    }

}
