package dev.elvir.morecommunication.ui.chat

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.chat.adapter.MessageAdapter
import kotlinx.android.synthetic.main.fmt_chat_screen.*
import javax.inject.Inject

const val CHAT_KEY: String = "CHAT_KEY"

class ChatScreenFragment : BaseActivity(), ChatContract.ChatMvpView {


    @Inject
    lateinit var presenter: ChatContract.ChatMvpPresenter
    lateinit var adapter: MessageAdapter
    private var listMessage: MutableList<Message> = mutableListOf()
    private var uid: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().inject(this)
        presenter.onAttach(this)
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
        adapter.listMessage = list
        rv_chat.adapter?.itemCount?.minus(1)?.let { rv_chat.scrollToPosition(it) }
    }


}