package dev.elvir.morecommunication.ui.chat_list_screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.db.dao.ChatDao
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.ui.chat_create_way.ChatCreateWayFragmentScreen
import dev.elvir.morecommunication.ui.chat_list_screen.adapter.ChatListAdapter
import dev.elvir.morecommunication.ui.search.SearchFragment
import kotlinx.android.synthetic.main.fmt_chat_list_screen.*
import javax.inject.Inject


class ChatListScreenFragment :
    Fragment(),
    ChatListContract.View,
    ChatCreateWayFragmentScreen.CallBack,
    ChatListAdapter.Callback {

    companion object {
        fun newInstance() = ChatListScreenFragment()
    }

    @Inject
    lateinit var chatDao: ChatDao

    lateinit var presenter: ChatListContract.Presenter

    lateinit var adapter: ChatListAdapter

    private var listChat: MutableList<Chat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).appComponent.inject(this)
        presenter = ChatListPresenter(this, chatDao)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fmt_chat_list_screen, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        iv_create_chat.setOnClickListener {
            val fragment =
                ChatCreateWayFragmentScreen.newInstance().also { it.registerCallback(this) }
            fragment.show(activity!!.supportFragmentManager, "")
        }
    }

    private fun setUpRecycler() {
        rv_chat_list.layoutManager = LinearLayoutManager(context!!)
        adapter = ChatListAdapter(listChat,this)
        rv_chat_list.adapter = adapter
    }

    override fun selected(type: Int) {
        startActivity(Intent(context, SearchFragment::class.java))
    }

    override fun showChatList(list: MutableList<Chat>) {
        for (chat in list) {
            listChat.add(chat)
            adapter.notifyItemInserted(listChat.size - 1)
        }
    }

    override fun selectedItem(chat: Chat) {
        TODO("Not yet implemented")
    }

}