package dev.elvir.morecommunication.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.data.interactor.*
import dev.elvir.morecommunication.di.component.ActivityScope

@Module
class InteractorModule {

    @ActivityScope
    @Provides
    fun provideSplashInteractor(splashInteractorImpl: SplashInteractorImpl)
            : SplashInteractor = splashInteractorImpl

    @ActivityScope
    @Provides
    fun provideSignInInteractor (signInInteractorImpl: SignInInteractorImpl)
            :SignInInteractor = signInInteractorImpl

    @ActivityScope
    @Provides
    fun provideSignInAnonymoslyInteractor(signInAnonymoslyImpl: SignInAnonymInteractorImpl)
            :SignInAnonymInteractor = signInAnonymoslyImpl

    @ActivityScope
    @Provides
    fun provideSignInModeInteractor(signInModeInteractorImpl: SignInModeInteractorImpl)
            :SignInModeInteractor = signInModeInteractorImpl

    @ActivityScope
    @Provides
    fun provideChatListInteractor(chatListInteractorImpl: ChatListInteractorImpl)
            :ChatListInteractor = chatListInteractorImpl

    @ActivityScope
    @Provides
    fun provideNewsListInteractor(newsListInteractorImpl: NewsListInteractorImpl)
            :NewsListInteractor = newsListInteractorImpl

    @ActivityScope
    @Provides
    fun provideSearchInteractor(searchInteractorImpl: SearchInteractorImpl)
            :SearchInteractor = searchInteractorImpl

    @ActivityScope
    @Provides
    fun provideChatInteractor(chatInteractorImpl: ChatInteractorImpl)
            :ChatInteractor = chatInteractorImpl





}