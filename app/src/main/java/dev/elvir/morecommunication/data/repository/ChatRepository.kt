package dev.elvir.morecommunication.data.repository

import android.util.Log
import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.data.entity.message.Message
import io.reactivex.Completable
import javax.inject.Inject

interface ChatRepository {

    fun saveChat(message: Message): Completable

}

class ChatRepositoryImpl @Inject constructor(
    val userRepository: CurrentUserRepository,
    val chatDao: ChatDao
) : ChatRepository {

    override fun saveChat(message: Message): Completable {
        val chatId = if (message.uidFrom == userRepository.getUid()) {
            message.uidFrom
        } else {
            message.uidTo
        }
        val chat = Chat(chatId = chatId, lastMessage = message)
        return Completable.fromAction {
            chatDao.upsert(chat)
        }
    }


}
