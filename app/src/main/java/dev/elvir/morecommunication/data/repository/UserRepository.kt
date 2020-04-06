package dev.elvir.morecommunication.data.repository

import dev.elvir.morecommunication.data.entity.user.UserEntity

interface UserRepository {

    fun addUid(uid : Long)
    fun getUid(): Long

}