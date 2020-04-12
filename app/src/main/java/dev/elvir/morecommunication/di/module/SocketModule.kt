package dev.elvir.morecommunication.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.data.repository.ChatRepository
import dev.elvir.morecommunication.di.component.AppScope
import dev.elvir.morecommunication.handler.GlobalSocketHandler
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.StompClient

const val DEBUG_ELVIR_HOST = "ws://192.168.43.244:9090/connect/websocket"
const val DEBUG_ALBINA_HOST = "ws://172.20.10.5:9090/connect/websocket"


@Module
class SocketModule {

    @AppScope
    @Provides
    fun provideStompClient(): StompClient =
        Stomp.over(Stomp.ConnectionProvider.OKHTTP, DEBUG_ALBINA_HOST)

    @AppScope
    @Provides
    fun provideGlobalSocketHandler(chatRepository: ChatRepository) =
        GlobalSocketHandler(chatRepository)
}

