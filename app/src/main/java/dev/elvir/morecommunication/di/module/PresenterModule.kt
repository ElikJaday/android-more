package dev.elvir.morecommunication.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.ActivityScope
import dev.elvir.morecommunication.ui.splas_screen.SplashContract
import dev.elvir.morecommunication.ui.splas_screen.SplashPresenter

@Module
class PresenterModule {
    @Provides
    @ActivityScope
    fun provideSplashPresenter(splashPresenter: SplashPresenter)
            : SplashContract.SplashPresenter =
        splashPresenter
}