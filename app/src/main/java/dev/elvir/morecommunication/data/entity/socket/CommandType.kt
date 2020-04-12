package dev.elvir.morecommunication.data.entity.socket

enum class CommandType(type: Int) {
    CREATE_ROOM(0),
    SEND_MESSAGE(1),
    ROOM_CREATED(2)
}