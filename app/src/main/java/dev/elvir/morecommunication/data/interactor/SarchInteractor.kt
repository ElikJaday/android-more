package dev.elvir.morecommunication.data.interactor

import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.network.api.ChatApi
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

interface SearchInteractor {
    fun searchUsers(userName: String): Single<List<UserEntity>>

}

class SearchInteractorImpl @Inject constructor(
    val retrofit: Retrofit
) : SearchInteractor {

    override fun searchUsers(userName: String): Single<List<UserEntity>> {
        return retrofit
            .create(ChatApi::class.java)
            .getSearch(userName)
    }

}