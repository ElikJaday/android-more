package dev.elvir.morecommunication.di.component

import dagger.Component
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.di.module.AppModule
import dev.elvir.morecommunication.di.module.NetworkModule
import dev.elvir.morecommunication.ui.sign_in_anonymously.SignInAnonymouslyScreenActivity
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Component(
    modules = [
        NetworkModule::class,
        AppModule::class
    ]
)
@AppScope
interface AppComponent {

    fun inject(app: App)
    fun inject(activity: SignInAnonymouslyScreenActivity)

}