package dev.elvir.morecommunication.ui.chat_list_screen

import dev.elvir.morecommunication.data.interactor.ChatListInteractor
import dev.elvir.morecommunication.ext.ioToMain
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ChatListPresenter @Inject constructor(
    private val chatInteractor: ChatListInteractor
) : ChatListContract.ChatListMvpPresenter {
    var view: ChatListContract.ChatListMvpView? = null
    var disposable: CompositeDisposable = CompositeDisposable()

    override fun fetchData() {
        disposable.add(
            chatInteractor.getAllChats()
                .ioToMain()
                .subscribe(
                    { view?.showChatList(it) },
                    { it.printStackTrace() },
                    {})
        )
    }

    override fun onAttach(view: ChatListContract.ChatListMvpView) {
        this.view = view
    }

}