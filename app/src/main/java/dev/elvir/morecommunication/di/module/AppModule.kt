package dev.elvir.morecommunication.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.AppScope

@Module
class AppModule(var application: Application) {

    lateinit var applicationInst: Application

    init {
        applicationInst = application
    }

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return applicationInst
    }

}