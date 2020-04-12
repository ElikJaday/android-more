package dev.elvir.morecommunication.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.ActivityScope
import dev.elvir.morecommunication.ui.chat.ChatContract
import dev.elvir.morecommunication.ui.chat.ChatPresenter
import dev.elvir.morecommunication.ui.chat_list_screen.ChatListContract
import dev.elvir.morecommunication.ui.chat_list_screen.ChatListPresenter
import dev.elvir.morecommunication.ui.news_list_screen.NewsListContract
import dev.elvir.morecommunication.ui.news_list_screen.NewsListPresenter
import dev.elvir.morecommunication.ui.search.SearchContract
import dev.elvir.morecommunication.ui.search.SearchPresenter
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

    @Provides
    @ActivityScope
    fun provideChatListRepostiroy(chatListPresenter: ChatListPresenter)
            : ChatListContract.ChatListMvpPresenter = chatListPresenter

    @Provides
    @ActivityScope
    fun provideNewsListPresenter(newsListPresenter: NewsListPresenter)
            : NewsListContract.NewsListMvpPresenter = newsListPresenter

    @Provides
    @ActivityScope
    fun provideSearchPresenter(searchPresenter: SearchPresenter)
            : SearchContract.SearchMvpPresenter = searchPresenter

    @Provides
    @ActivityScope
    fun provideChatPresenter(chatPresenter: ChatPresenter)
            : ChatContract.ChatMvpPresenter = chatPresenter

}