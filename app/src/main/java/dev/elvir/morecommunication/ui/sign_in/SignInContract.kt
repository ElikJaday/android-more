package dev.elvir.morecommunication.ui.sign_in

import dev.elvir.morecommunication.ui.base.Presenter
import dev.elvir.morecommunication.ui.base.View

interface SignInContract {

    interface SignInMvpView : View {

    }

    interface SignInMvpPresenter : Presenter<SignInMvpView>{

    }
}