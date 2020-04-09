package dev.elvir.morecommunication

import android.app.Application
import dev.elvir.morecommunication.di.component.AppComponent
import dev.elvir.morecommunication.di.component.DaggerAppComponent
import dev.elvir.morecommunication.di.module.AppModule
import dev.elvir.morecommunication.di.module.RoomModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (!this::appComponent.isInitialized) {
            appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()
                .also { it.inject(this) }
        }
    }

    fun getApplicationComponent()
            :AppComponent = appComponent

}
