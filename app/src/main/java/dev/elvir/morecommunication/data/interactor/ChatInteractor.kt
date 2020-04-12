package dev.elvir.morecommunication.data.interactor

import com.google.gson.Gson
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.entity.socket.CommandType
import dev.elvir.morecommunication.data.entity.socket.Container
import dev.elvir.morecommunication.data.repository.ChatRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

interface ChatInteractor {
    fun getAllMessages(chatId: Long): Flowable<MutableList<Message>>
    fun sendMessage(message: String, toUser: Long): Completable
}

class ChatInteractorImpl @Inject constructor(
    private val userRepository: CurrentUserRepository
    , private val chatRepository: ChatRepository
) : ChatInteractor {
    lateinit var container: Container
    lateinit var message: Message

    override fun getAllMessages(chatId: Long): Flowable<MutableList<Message>> {
        return chatRepository.getAll(chatId)
    }

    override fun sendMessage(message: String, toUser: Long): Completable {
        this.message = Message(
            Calendar.getInstance().time.time,
            null,
            message,
            userRepository.getUid(),
            toUser
        )
        val body = Gson().toJson(this.message)
        container = Container(body, CommandType.SEND_MESSAGE)
        val json = Gson().toJson(container)
        return chatRepository.sendMessage(json)

    }


}