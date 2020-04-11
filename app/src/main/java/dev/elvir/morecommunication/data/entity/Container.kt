package dev.elvir.morecommunication.data.entity

import com.squareup.moshi.Json

data class Container(
    val body: String,
    val commandType: CommandType
)