package dev.elvir.morecommunication.data.entity.chat

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Chat(
    @PrimaryKey
    var chatId: Long = 0
) : Parcelable