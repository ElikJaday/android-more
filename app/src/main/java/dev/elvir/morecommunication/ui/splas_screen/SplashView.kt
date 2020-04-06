package dev.elvir.morecommunication.ui.splas_screen

interface SplashContract {

    interface SplashView{

       fun goToSignInMode()

    }

    interface SplashPresenter{

       fun checkVersion()

    }

}