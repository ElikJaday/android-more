package dev.elvir.morecommunication

import android.annotation.SuppressLint
import android.app.Application
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import dev.elvir.morecommunication.di.component.AppComponent
import dev.elvir.morecommunication.di.component.DaggerAppComponent
import dev.elvir.morecommunication.di.module.AppModule
import dev.elvir.morecommunication.di.module.RoomModule
import dev.elvir.morecommunication.ext.ioToMain
import dev.elvir.morecommunication.handler.GlobalSocketHandler
import ua.naiksoftware.stomp.StompClient
import ua.naiksoftware.stomp.dto.LifecycleEvent
import javax.inject.Inject

@SuppressLint("CheckResult")
class App : Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var stompClient: StompClient

    @Inject
    lateinit var globalSocketHandler: GlobalSocketHandler

    @Inject
    lateinit var authRepository: AuthRepository

    @Inject
    lateinit var userRepository: CurrentUserRepository

    override fun onCreate() {
        checkDi()
        checkAuth()
        super.onCreate()
    }

    private fun checkDi() {
        if (!this::appComponent.isInitialized) {
            initDagger()
        }
    }

    private fun initDagger(): AppComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .roomModule(RoomModule(this))
        .build()
        .also {
            appComponent = it
            appComponent.inject(this)
        }

    private fun checkAuth() = authRepository.getAuthEntity()
        .ioToMain()
        .subscribe(
            {
                if (it.authState == AuthState.ACTIVATED) {
                    stompClient.connect()
                    subscribeSocketLifecycle()
                    subscibeSocketChanel()
                }
            },
            {
                it.printStackTrace()
            })


    private fun subscribeSocketLifecycle() {
        if (stompClient.isConnected) {
            stompClient.lifecycle()
                .ioToMain()
                .subscribe(
                    {
                        when (it.type) {
                            LifecycleEvent.Type.OPENED -> {
                            }
                            LifecycleEvent.Type.CLOSED -> {
                            }
                            LifecycleEvent.Type.ERROR -> {
                                it.exception.printStackTrace()
                            }
                        }
                    },
                    { it.printStackTrace() }
                )
        }
    }

    private fun subscibeSocketChanel() {
        stompClient.topic("/consumer/${userRepository.getUid()}")
            .ioToMain()
            .subscribe(
                {
                    globalSocketHandler.handlerChanelReceiveMessage(it.payload)
                },
                {}
            )

    }


}



