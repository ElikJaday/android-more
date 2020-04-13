package dev.elvir.morecommunication.data.repository

import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.entity.chat.MessageType
import io.reactivex.Completable
import io.reactivex.Flowable
import ua.naiksoftware.stomp.StompClient
import java.util.*
import javax.inject.Inject

interface ChatRepository {

    fun saveChat(message: Message): Completable
    fun sendMessage(json: String): Completable
    fun getAll(chatId: Long): Flowable<MutableList<Message>>

}

class ChatRepositoryImpl @Inject constructor(
    val userRepository: CurrentUserRepository,
    val chatDao: ChatDao,
    val stompClient: StompClient
) : ChatRepository {

    override fun saveChat(message: Message): Completable = Completable.fromAction {
        val m = message
        val chat : Chat
        val chatId = if (message.uidFrom == userRepository.getUid()) {
            m.messageType = MessageType.OUTCOMING
            message.uidTo
        } else {
            m.messageType = MessageType.INCOMING
            m.clientTime = Calendar.getInstance().time.time
            message.uidFrom

        }

        m.chatLinkId = chatId
        chatDao.upsertChat(Chat(chatId,))
        chatDao.upsertMessage(m)
    }

    override fun sendMessage(json: String): Completable {
        return stompClient.send("/chat-signalling", json)
    }

    override fun getAll(chatId: Long): Flowable<MutableList<Message>> = chatDao.getAllMsg(chatId)

}
