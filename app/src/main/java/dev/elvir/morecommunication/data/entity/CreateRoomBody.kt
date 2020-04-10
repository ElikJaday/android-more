package dev.elvir.morecommunication.data.entity

data class CreateRoomBody(
    var memberList: List<Long>,
    var text : String
)


