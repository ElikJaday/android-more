package dev.elvir.morecommunication.data.network.api

import dev.elvir.morecommunication.data.entity.user.UserEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatApi {

    @GET("user/findByNickName/{search}")
    fun getSearch(@Path("search") search: String): Single<List<UserEntity>>

}