package dev.elvir.morecommunication.ui.chat

import android.annotation.SuppressLint
import dev.elvir.morecommunication.data.interactor.ChatInteractor
import dev.elvir.morecommunication.ext.ioToMain
import javax.inject.Inject

@SuppressLint("CheckResult")
class ChatPresenter @Inject constructor(
    private val chatInteractor: ChatInteractor
) : ChatContract.ChatMvpPresenter {
    private var mvpView :ChatContract.ChatMvpView?=null

    override fun fetchMessage(chatId: Long) {
        chatInteractor.getAllMessages(chatId)
            .ioToMain()
            .subscribe(
                {
                    mvpView?.showMessage(it)
                },
                { it.printStackTrace() },
                {}
            )
    }

    override fun sendMessage(message: String, toUser: Long) {
        chatInteractor
            .sendMessage(message, toUser)
            .subscribe()
    }

    override fun onAttach(view: ChatContract.ChatMvpView) {
        this.mvpView = view

    }


}


