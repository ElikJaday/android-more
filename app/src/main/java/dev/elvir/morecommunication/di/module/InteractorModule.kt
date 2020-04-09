package dev.elvir.morecommunication.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.data.interactor.SplashInteractor
import dev.elvir.morecommunication.data.interactor.SplashInteractorImpl
import dev.elvir.morecommunication.di.component.ActivityScope

@Module
class InteractorModule {

    @ActivityScope
    @Provides
    fun provideSplashInteractor(splashInteractorImpl: SplashInteractorImpl)
            : SplashInteractor = splashInteractorImpl
}