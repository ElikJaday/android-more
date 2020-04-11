package dev.elvir.morecommunication.ui.sign_in_mode

import dev.elvir.morecommunication.data.interactor.SignInModeInteractor
import javax.inject.Inject


class SignInModePresenter @Inject constructor(
    private val signInModeInteractor: SignInModeInteractor)
    :SignInModeContract.SignInModeMvpPresenter{
    private var mvpView: SignInModeContract.SignInModeMvpView? = null


    override fun onAttach(view: SignInModeContract.SignInModeMvpView) {
        this.mvpView = view

    }

}