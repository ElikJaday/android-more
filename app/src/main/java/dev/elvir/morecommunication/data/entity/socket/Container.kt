package dev.elvir.morecommunication.data.entity.socket

import dev.elvir.morecommunication.data.entity.socket.CommandType

data class Container(
    val body: String,
    val commandType: CommandType
)