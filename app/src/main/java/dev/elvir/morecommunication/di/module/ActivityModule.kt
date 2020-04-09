package dev.elvir.morecommunication.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.di.component.ActivityScope

@Module
class ActivityModule(var activity: Activity) {

    @Provides
    @ActivityScope
    fun provideAcivityContext(): Activity = activity
}