package dev.elvir.morecommunication.ui.sign_in_anonymously

import android.annotation.SuppressLint
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.interactor.SignInAnonymInteractor
import dev.elvir.morecommunication.data.network.api.AuthApi
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

@SuppressLint("CheckResult")
class SignInAnonymouslyPresenter @Inject constructor(
    private val interactor: SignInAnonymInteractor
) : SignInAnonymouslyContract.SignInAnonymMvpPresenter {
    private var mvpView: SignInAnonymouslyContract.SignInAnonymMvpView? = null

    override fun clickEnter(userNickname: String) {
        interactor
            .authAnonymosly(userNickname)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                saveAllData(it)
                mvpView?.goToMainMenu()

            }, {})
    }

    private fun saveAllData(userEntity: UserEntity) {
        interactor.saveAllData(userEntity)

    }

    override fun clickSelectImage() {
        mvpView?.showSelectImage()
    }

    override fun onAttach(view: SignInAnonymouslyContract.SignInAnonymMvpView) {
        this.mvpView = view
    }

}