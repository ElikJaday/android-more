package dev.elvir.morecommunication.data.repository

import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.data.entity.chat.Message
import io.reactivex.Completable
import javax.inject.Inject

interface ChatRepository {

    fun saveChat(message: Message): Completable

}

class ChatRepositoryImpl @Inject constructor(
    val userRepository: CurrentUserRepository,
    val chatDao: ChatDao
) : ChatRepository {

    override fun saveChat(message: Message): Completable = Completable.fromAction {
        val chatId = if (message.uidFrom == userRepository.getUid()) {
            message.uidFrom
        } else {
            message.uidTo
        }
        chatDao.upsertChat(Chat(chatId))
        chatDao.upsertMessage(message)
    }


}
