package dev.elvir.morecommunication.ui.splas_screen

import android.os.Handler

class SplashPresenter(
    val view: SplashContract.SplashView
) : SplashContract.SplashPresenter {

    override fun checkVersion() {
        Handler().postDelayed({
            view.goToSignInMode()
        }, 200)
    }

}