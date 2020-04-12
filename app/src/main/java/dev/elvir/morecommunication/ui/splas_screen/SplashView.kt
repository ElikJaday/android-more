package dev.elvir.morecommunication.ui.splas_screen

import dev.elvir.morecommunication.ui.base.Presenter
import dev.elvir.morecommunication.ui.base.View

interface SplashContract {

    interface SplashView :View{

       fun goToSignInMode()
       fun goToMainMenu()

    }

    interface SplashPresenter : Presenter<SplashView>{

       fun checkVersion()
       fun checkAuthState()

    }

}