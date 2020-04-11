package dev.elvir.morecommunication.ui.sign_in

import dev.elvir.morecommunication.data.interactor.SignInInteractor
import javax.inject.Inject

class SignInPresenter @Inject constructor(
    private val signInInteractor: SignInInteractor)
    : SignInContract.SignInMvpPresenter {
    private var mvpView: SignInContract.SignInMvpView? = null


    override fun onAttach(view: SignInContract.SignInMvpView) {
        this.mvpView = view
    }
}