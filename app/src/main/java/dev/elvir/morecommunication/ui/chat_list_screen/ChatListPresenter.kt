package dev.elvir.morecommunication.ui.chat_list_screen

import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.ext.ioToMain
import io.reactivex.disposables.CompositeDisposable

class ChatListPresenter(
    val view: ChatListContract.View,
    val chatDao: ChatDao
) : ChatListContract.Presenter {
    var disposable: CompositeDisposable = CompositeDisposable()

    override fun fetchData() {
        disposable.add(
            chatDao.getAll()
                .ioToMain()
                .subscribe(
                    {view.showChatList(it)},
                    { it.printStackTrace() },
                    {})
        )
    }

}