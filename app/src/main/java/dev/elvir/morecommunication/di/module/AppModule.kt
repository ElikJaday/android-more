package dev.elvir.morecommunication.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.AppScope

@Module
class AppModule(var application: Application) {

    var applicationInst: Application = application

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return applicationInst
    }

}