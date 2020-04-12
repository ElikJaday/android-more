package dev.elvir.morecommunication.data.entity.socket

data class CreateRoomBody(
    var memberList: List<Long>,
    var text : String
)


