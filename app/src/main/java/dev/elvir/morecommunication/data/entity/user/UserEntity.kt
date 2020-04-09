package dev.elvir.morecommunication.data.entity.user

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var userName: String?="",
    var nickName: String?="",
    var userPhone: String?="",
    var uid : Long = 0L
) : Parcelable


