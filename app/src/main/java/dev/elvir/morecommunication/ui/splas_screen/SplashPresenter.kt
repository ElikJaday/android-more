package dev.elvir.morecommunication.ui.splas_screen

import android.annotation.SuppressLint
import android.os.Handler
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.repository.AuthRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class SplashPresenter(
    val view: SplashContract.SplashView,
    val authRepository: AuthRepository
) : SplashContract.SplashPresenter {

    override fun checkVersion() {
        Handler().postDelayed({
           checkAuthState()
        }, 100)
    }

    override fun checkAuthState() {
        authRepository.getAuthEntity()
            .onErrorReturn { AuthEntity(authState = AuthState.NOT_ACTIVATED) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.authState == AuthState.ACTIVATED) {
                    view.goToMainMenu()
                } else {
                    view.goToSignInMode()
                }
            },
                {
                    it.printStackTrace()

                }
            )
    }

}