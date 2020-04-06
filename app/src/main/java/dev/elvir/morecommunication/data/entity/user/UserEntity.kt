package dev.elvir.morecommunication.data.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var userName: String = "",
    var nickName: String,
    var userPhone: String
//    var userType: UserTypeEntity,
//    var userImage: UserImageEntity
)


