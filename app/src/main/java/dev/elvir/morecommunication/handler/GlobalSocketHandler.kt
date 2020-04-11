package dev.elvir.morecommunication.handler

import com.google.gson.Gson
import dev.elvir.morecommunication.data.entity.socket.CommandType
import dev.elvir.morecommunication.data.entity.socket.Container
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.repository.ChatRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GlobalSocketHandler @Inject constructor(
    val chatRepository: ChatRepository
) {
    lateinit var container: Container
    lateinit var message: Message
    private var gson = Gson()

    fun handlerChanelReceiveMessage(payload: String) {
        container = gson.fromJson(payload, Container::class.java)
        handlerCommandType(container)
    }

    private fun handlerCommandType(container: Container) {
        when (container.commandType) {
            CommandType.SEND_MESSAGE -> {
                message = gson.fromJson(container.body, Message::class.java)
                chatRepository.saveChat(message)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({},{it.printStackTrace()})
            }
            else -> IllegalStateException("Command type Illegal")
        }
    }


}