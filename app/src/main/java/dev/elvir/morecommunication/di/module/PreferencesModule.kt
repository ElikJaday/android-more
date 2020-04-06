package dev.elvir.morecommunication.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.AppScope

@Module
class PreferencesModule {

    companion object {
        private const val MAIN_SHARED_PREFERENCES = "main_shared_preferences"
    }

    @Provides
    @AppScope
    fun provideMainSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(MAIN_SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }


}