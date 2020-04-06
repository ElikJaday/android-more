package dev.elvir.morecommunication.data.api

import dev.elvir.morecommunication.data.model.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

public interface AuthApi {

    @POST("user/create")
    fun authAnonymously(@Body user: User): Single<Unit>

}