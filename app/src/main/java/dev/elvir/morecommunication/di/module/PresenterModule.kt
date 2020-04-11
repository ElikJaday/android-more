package dev.elvir.morecommunication.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.ActivityScope
import dev.elvir.morecommunication.ui.sign_in.SignInContract
import dev.elvir.morecommunication.ui.sign_in.SignInPresenter
import dev.elvir.morecommunication.ui.sign_in_anonymously.SignInAnonymouslyContract
import dev.elvir.morecommunication.ui.sign_in_anonymously.SignInAnonymouslyPresenter
import dev.elvir.morecommunication.ui.sign_in_mode.SignInModeContract
import dev.elvir.morecommunication.ui.sign_in_mode.SignInModePresenter
import dev.elvir.morecommunication.ui.splas_screen.SplashContract
import dev.elvir.morecommunication.ui.splas_screen.SplashPresenter

@Module
class PresenterModule {
    @Provides
    @ActivityScope
    fun provideSplashPresenter(splashPresenter: SplashPresenter)
            : SplashContract.SplashPresenter =
        splashPresenter

    @Provides
    @ActivityScope
    fun provideSignInPresenter(signInPresenter: SignInPresenter)
            : SignInContract.SignInMvpPresenter = signInPresenter

    @Provides
    @ActivityScope
    fun provideSignInModePresenter(signInModePresenter: SignInModePresenter)
            : SignInModeContract.SignInModeMvpPresenter = signInModePresenter

    @Provides
    @ActivityScope
    fun provideSignInAnonymPresenter(signInAnonymouslyPresenter: SignInAnonymouslyPresenter)
            : SignInAnonymouslyContract.SignInAnonymMvpPresenter = signInAnonymouslyPresenter

}