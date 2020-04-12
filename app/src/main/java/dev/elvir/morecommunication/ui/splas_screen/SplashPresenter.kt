package dev.elvir.morecommunication.ui.splas_screen

import android.annotation.SuppressLint
import android.os.Handler
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.interactor.SplashInteractor
import dev.elvir.morecommunication.data.repository.AuthRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class SplashPresenter @Inject constructor(
   private val splashInteractor: SplashInteractor
) : SplashContract.SplashPresenter {
    private var mvpView:SplashContract.SplashView?=null

    override fun checkVersion() {
        Handler().postDelayed({
           checkAuthState()
        }, 100)
    }

    override fun checkAuthState() {
        splashInteractor.getAuthEntity()
            .onErrorReturn { AuthEntity(authState = AuthState.NOT_ACTIVATED) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.authState == AuthState.ACTIVATED) {
                    mvpView?.goToMainMenu()
                } else {
                    mvpView?.goToSignInMode()
                }
            },
                {
                    it.printStackTrace()

                }
            )
    }

    override fun onAttach(view: SplashContract.SplashView) {
        this.mvpView = view
    }

}