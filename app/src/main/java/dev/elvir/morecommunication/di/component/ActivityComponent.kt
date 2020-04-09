package dev.elvir.morecommunication.di.component

import dagger.Component
import dev.elvir.morecommunication.di.module.ActivityModule
import dev.elvir.morecommunication.di.module.InteractorModule
import dev.elvir.morecommunication.di.module.PresenterModule
import dev.elvir.morecommunication.ui.splas_screen.SplashScreenActivity
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@Component(
    dependencies = [AppComponent::class],
    modules = [
        PresenterModule::class,
        ActivityModule::class,
        InteractorModule::class
    ]
)
@ActivityScope
interface ActivityComponent {
    fun inject(splashScreenActivity: SplashScreenActivity)
}
