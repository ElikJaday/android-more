package dev.elvir.morecommunication.ui.chat

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.message.Message
import dev.elvir.morecommunication.data.entity.message.MessageType
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.chat.adapter.MessageAdapter
import kotlinx.android.synthetic.main.fmt_chat_screen.*
import javax.inject.Inject

class ChatScreenFragment : BaseActivity(), ChatContract.View {

    lateinit var presenter: ChatContract.Presenter

    @Inject
    lateinit var userRepository: CurrentUserRepository

    lateinit var userEntity: UserEntity
    lateinit var adapter: MessageAdapter
    var listMessage: MutableList<Message> = mutableListOf()
    var createdRoom: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        presenter = ChatPresenter(this, userRepository)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fmt_chat_screen)
        setUpRecylerView()
        setUpListener()
    }

    private fun setUpListener() {
        btn_send.setOnClickListener {
            if (createdRoom) {
                presenter.sendMessage(et_message.text.toString())
            } else {
                presenter.createRoomAndSendMessage(userEntity, et_message.text.toString())
            }
        }
    }


    private fun setUpRecylerView() {
        val l = LinearLayoutManager(this)
        l.stackFromEnd = false
        l.reverseLayout = false
        rv_chat.layoutManager = l
        adapter = MessageAdapter(listMessage)
        rv_chat.adapter = adapter
    }


    override fun onResume() {
        super.onResume()
        userEntity = intent.getParcelableExtra("user") as UserEntity
        Log.e("Info", "" + userEntity.uid)
    }

    override fun addMessage(text: String) {
        listMessage.add(Message(text, 0, 0, 0, MessageType.OUTCOMING))
        adapter.notifyItemInserted(listMessage.size - 1)
        rv_chat.adapter?.itemCount?.minus(1)?.let { rv_chat.scrollToPosition(it) }
    }


}