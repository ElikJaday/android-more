package dev.elvir.morecommunication.ui.splas_screen

interface SplashContract {

    interface SplashView{

       fun goToSignInMode()
       fun goToMainMenu()

    }

    interface SplashPresenter{

       fun checkVersion()
       fun checkAuthState()

    }

}