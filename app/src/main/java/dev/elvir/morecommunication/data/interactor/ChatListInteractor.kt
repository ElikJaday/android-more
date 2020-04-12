package dev.elvir.morecommunication.data.interactor

import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.data.repository.ChatRepository
import io.reactivex.Flowable
import javax.inject.Inject

interface ChatListInteractor {

    fun getAllChats(): Flowable<MutableList<Chat>>

}

class ChatListInteractorImpl @Inject constructor(
    private val chatRepository: ChatRepository)
    : ChatListInteractor {

    override fun getAllChats(): Flowable<MutableList<Chat>> = chatRepository.getAllChats()

}