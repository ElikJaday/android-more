package dev.elvir.morecommunication

import android.app.Application
import dev.elvir.morecommunication.di.component.AppComponent
import dev.elvir.morecommunication.di.component.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (!this::appComponent.isInitialized) {
            appComponent = DaggerAppComponent
                .builder()
                .build()
                .also { it.inject(this) }
        }
    }

}

//applicationComponent = DaggerApplicationComponent.builder()
//.netModule(NetModule())
//.build()
//
//applicationComponent.inject(this)