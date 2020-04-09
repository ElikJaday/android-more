package dev.elvir.morecommunication.data.repository

import dev.elvir.morecommunication.data.entity.user.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface CurrentUserRepository {

    fun addUid(uid : Long)
    fun getUid(): Long
    fun addUser(userEntity: UserEntity) : Completable
    fun getUser(): Single<UserEntity>

    fun save(uid: Long)
    fun gets():Long

}