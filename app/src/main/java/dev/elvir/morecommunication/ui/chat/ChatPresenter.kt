package dev.elvir.morecommunication.ui.chat

import com.google.gson.Gson
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.StompClient

class ChatPresenter(
    val view: ChatContract.View,
    val userRepository: CurrentUserRepository
) : ChatContract.Presenter {
    lateinit var stompClient: StompClient

    init {
        startSocket()
    }

    override fun sendMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun createRoomAndSendMessage(userEntity: UserEntity, msg: String) {
        val json = Gson().toJson(
            RoomOffer(
                listOf(userEntity.uid, userRepository.getUid()),
                Message(null, msg)
            )
        )
        createRoom(json)
    }

    private fun startSocket() {
        stompClient = Stomp.over(
            Stomp.ConnectionProvider.OKHTTP,
            "ws://192.168.43.244:9090/connect/websocket"
        );
        stompClient.connect();

        stompClient.topic("/chat/${userRepository.getUid()}").subscribe {
            it
        }

    }

    private fun createRoom(json: String) {
        stompClient.send("/create-chat", json).subscribe { }
    }

    private fun send(json: String) {

    }

}


class RoomOffer(
    var memberList: List<Long>,
    var message: Message
)

class Message(
    var roomId: Long? = null,
    var msg: String
)


