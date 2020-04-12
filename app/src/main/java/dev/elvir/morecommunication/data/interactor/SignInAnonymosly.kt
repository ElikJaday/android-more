package dev.elvir.morecommunication.data.interactor

import android.annotation.SuppressLint
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.network.api.AuthApi
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

interface SignInAnonymInteractor {

    fun authAnonymosly(userNickname: String): Single<UserEntity>
    fun saveAllData(userEntity: UserEntity)

}

@SuppressLint("CheckResult")
class SignInAnonymInteractorImpl @Inject constructor(
    private val retrofit: Retrofit,
    private val currentUserRepository: CurrentUserRepository,
    private val authRepository: AuthRepository
) : SignInAnonymInteractor {

    override fun authAnonymosly(userNickname: String): Single<UserEntity> {
        return retrofit.create(AuthApi::class.java)
            .authAnonymously(UserEntity(nickName = userNickname))
    }


    override fun saveAllData(userEntity: UserEntity) {
        currentUserRepository.addUid(userEntity.uid)
        currentUserRepository.addUser(userEntity)
            .andThen(
                authRepository.addAuthEntity(
                    AuthEntity(authState = AuthState.ACTIVATED)
                )
            )
    }


}