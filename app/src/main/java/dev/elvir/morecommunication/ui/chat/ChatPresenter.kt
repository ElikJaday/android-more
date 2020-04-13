package dev.elvir.morecommunication.ui.chat

import android.annotation.SuppressLint
import com.google.gson.Gson
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.entity.socket.CommandType
import dev.elvir.morecommunication.data.entity.socket.Container
import dev.elvir.morecommunication.data.repository.ChatRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import dev.elvir.morecommunication.ext.ioToMain
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

@SuppressLint("CheckResult")
class ChatPresenter(
    val view: ChatContract.View,
    val userRepository: CurrentUserRepository,
    val chatRepository: ChatRepository
) : ChatContract.Presenter {
    lateinit var container: Container
    lateinit var message: Message

    override fun fetchMessage(chatId: Long) {
        chatRepository.getAll(chatId)
            .ioToMain()
            .subscribe(
                {
                    view.showMessage(it)
                },
                { it.printStackTrace() },
                {}
            )
    }

    override fun sendMessage(message: String, toUser: Long) {
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
        chatRepository.sendMessage(json).subscribe()
        this.message.clientTime = Calendar.getInstance().time.time
        chatRepository.saveChat(this.message)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }


}


