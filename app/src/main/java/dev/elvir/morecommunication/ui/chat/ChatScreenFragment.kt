package dev.elvir.morecommunication.ui.chat

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.repository.ChatRepository
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.chat.adapter.MessageAdapter
import kotlinx.android.synthetic.main.fmt_chat_screen.*
import javax.inject.Inject

const val CHAT_KEY: String = "CHAT_KEY"

class ChatScreenFragment : BaseActivity(), ChatContract.View {

    @Inject
    lateinit var userRepository: CurrentUserRepository

    @Inject
    lateinit var chatRepository: ChatRepository

    lateinit var presenter: ChatContract.Presenter
    lateinit var adapter: MessageAdapter
    private var listMessage: MutableList<Message> = mutableListOf()
    private var uid: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        presenter = ChatPresenter(this, userRepository, chatRepository)
        super.onCreate(savedInstanceState)
        uid = intent.getLongExtra(CHAT_KEY, 0)
        setContentView(R.layout.fmt_chat_screen)
        setUpRecylerView()
        setUpListener()
        presenter.fetchMessage(uid)
    }

    private fun setUpListener() {
        btn_send.setOnClickListener {
            presenter.sendMessage(
                toUser = uid, message = et_message.text.toString()
            )
        }
    }


    private fun setUpRecylerView() {
        rv_chat.layoutManager = LinearLayoutManager(this)
        adapter = MessageAdapter()
        rv_chat.adapter = adapter
    }

    override fun showMessage(list: MutableList<Message>) {
        list
        adapter.listMessage = list
        rv_chat.adapter?.itemCount?.minus(1)?.let { rv_chat.scrollToPosition(it) }
    }


}