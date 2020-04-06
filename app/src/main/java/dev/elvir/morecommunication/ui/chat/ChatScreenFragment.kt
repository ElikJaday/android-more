package dev.elvir.morecommunication.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.message.Message
import dev.elvir.morecommunication.data.entity.message.MessageType
import kotlinx.android.synthetic.main.fmt_chat_screen.*

class ChatScreenFragment : Fragment() {

    var listMessage: MutableList<Message> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fmt_chat_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMessageList()
        rv_chat.layoutManager = LinearLayoutManager(context!!)
        rv_chat.adapter = MessageAdapter(listMessage)
    }

    private fun addMessageList() {
        listMessage.add(
            Message(
                "hello",
                MessageType.OUTCOMING
            )
        )
        listMessage.add(
            Message(
                "How are you, bro ?",
                MessageType.OUTCOMING
            )
        )
        listMessage.add(
            Message(
                "hey :)",
                MessageType.INCOMING
            )
        )
        listMessage.add(
            Message(
                "I am fine.Are you ?",
                MessageType.INCOMING
            )
        )
        listMessage.add(
            Message(
                "what did you do yesterday ?",
                MessageType.OUTCOMING
            )
        )
    }

    fun newInstance() = ChatScreenFragment()

}