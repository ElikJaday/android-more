package dev.elvir.morecommunication.di.module

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.data.db.dao.AuthDao
import dev.elvir.morecommunication.data.db.dao.UserDao
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.data.repository.AuthRepositoryImpl
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepositoryImpl
import dev.elvir.morecommunication.di.component.AppScope

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

}