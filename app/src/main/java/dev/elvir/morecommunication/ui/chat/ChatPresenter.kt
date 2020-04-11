package dev.elvir.morecommunication.ui.chat

import android.annotation.SuppressLint
import com.google.gson.Gson
import dev.elvir.morecommunication.data.entity.socket.CommandType
import dev.elvir.morecommunication.data.entity.socket.Container
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.entity.chat.MessageType
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.StompClient
import ua.naiksoftware.stomp.dto.StompMessage
import java.util.*

@SuppressLint("CheckResult")
class ChatPresenter(
    val view: ChatContract.View,
    val userRepository: CurrentUserRepository
) : ChatContract.Presenter {

    var stompClient: StompClient =
        Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://192.168.43.244:9090/connect/websocket")

    init {
        stompClient.connect()
        stompClient.topic("/consumer/${userRepository.getUid()}")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handler(it) }
    }

    override fun sendMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun createRoomAndSendMessage(userEntity: UserEntity, toString: String) {
        val body: String = Gson().toJson(
            Message(
                Calendar.getInstance().time.time,
                null,
                toString,
                userRepository.getUid(),
                userEntity.uid,
                MessageType.INCOMING

            )
        )
        val json = Gson().toJson(
            Container(
                commandType = CommandType.SEND_MESSAGE,
                body = body
            )
        )
        createRoom(json)
    }


    private fun createRoom(json: String) {
        stompClient.send("/create-chat", json).subscribe {

        }
    }

    private fun handler(stompMessage: StompMessage) {
        val container: Container = Gson().fromJson(stompMessage.payload, Container::class.java)
        if (container.commandType == CommandType.SEND_MESSAGE) {
            val message: Message = Gson().fromJson(container.body, Message::class.java)
            view.addMessage(message.text)
        }
    }


}


