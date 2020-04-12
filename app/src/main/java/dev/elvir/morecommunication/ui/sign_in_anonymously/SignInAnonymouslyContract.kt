package dev.elvir.morecommunication.ui.sign_in_anonymously

import dev.elvir.morecommunication.ui.base.Presenter

interface SignInAnonymouslyContract {

    interface SignInAnonymMvpView{

        fun showSelectImage()
        fun goToMainMenu()
    }

    interface SignInAnonymMvpPresenter:Presenter<SignInAnonymMvpView> {
        fun clickEnter(userNickname: String)
        fun clickSelectImage()
    }
}