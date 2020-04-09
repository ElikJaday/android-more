package dev.elvir.morecommunication.data.network.api

import dev.elvir.morecommunication.data.entity.user.UserEntity
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("user/create")
    fun authAnonymously(@Body userEntity: UserEntity): Single<UserEntity>

}