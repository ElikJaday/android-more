package dev.elvir.morecommunication.ui.sign_in_anonymously

import android.annotation.SuppressLint
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.network.api.AuthApi
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

@SuppressLint("CheckResult")
class SignInAnonymouslyPresenter(
    val view: SignInAnonymouslyContract.View,
    val retrofit: Retrofit,
    val currentUserRepository: CurrentUserRepository,
    val authRepository: AuthRepository
) : SignInAnonymouslyContract.Presenter {

    override fun clickEnter(userNickname: String) {
        retrofit.create(AuthApi::class.java)
            .authAnonymously(UserEntity(nickName = userNickname))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                saveAllData(it)
                view.goToMainMenu()

            }, {})
    }

    private fun saveAllData(userEntity: UserEntity) {
        currentUserRepository.addUid(userEntity.uid)
        currentUserRepository.addUser(userEntity)
            .andThen(
                authRepository.addAuthEntity(
                    AuthEntity(authState = AuthState.ACTIVATED)
                )
            )
    }

    override fun clickSelectImage() {
        view.showSelectImage()
    }

}