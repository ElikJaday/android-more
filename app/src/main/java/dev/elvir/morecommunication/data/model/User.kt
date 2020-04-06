package dev.elvir.morecommunication.data.model

data class User(
    var userName: String = "",
    var nickName: String,
    var userPhone: String,
    var userType: UserType,
    var userImage: UserImage
)

data class UserImage(
    val imageName: String,
    val type :String,
    val pic: ByteArray
)

enum class UserType {
    AUTHORIZED, ANONYMOUSLY
}