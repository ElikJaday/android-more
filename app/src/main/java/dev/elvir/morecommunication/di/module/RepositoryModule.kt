package dev.elvir.morecommunication.di.module

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.data.db.dao.AuthDao
import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.data.db.dao.UserDao
import dev.elvir.morecommunication.data.repository.*
import dev.elvir.morecommunication.di.component.AppScope
import ua.naiksoftware.stomp.StompClient

@Module
class RepositoryModule {

    @AppScope
    @Provides
    public fun provideUserRepository(
        sharedPreferences: SharedPreferences,
        userDao: UserDao
    ): CurrentUserRepository =
        CurrentUserRepositoryImpl(
            sharedPreferences,
            userDao
        )


    @AppScope
    @Provides
    public fun provideAuthRepository(
        sharedPreferences: SharedPreferences,
        authDao: AuthDao
    ): AuthRepository =
        AuthRepositoryImpl(
            sharedPreferences,
            authDao
        )


    @AppScope
    @Provides
    public fun provideChatRepository(
        userRepository: CurrentUserRepository,
        chatDao: ChatDao,
        stompClient: StompClient
    ): ChatRepository =
        ChatRepositoryImpl(
            userRepository,
            chatDao,
            stompClient
        )

}