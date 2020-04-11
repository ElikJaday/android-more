package dev.elvir.morecommunication.ui.sign_in_mode

import dev.elvir.morecommunication.ui.base.Presenter

interface SignInModeContract {

    interface SignInModeMvpView {

        fun goToSignInAnonymouslyScreen()
        fun goToSignInScreen()

    }

    interface SignInModeMvpPresenter : Presenter<SignInModeMvpView> {

    }

}