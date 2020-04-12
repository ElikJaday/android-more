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
import dev.elvir.morecommunication.ui.base.BaseFragment
import dev.elvir.morecommunication.ui.chat.CHAT_KEY
import dev.elvir.morecommunication.ui.chat.ChatScreenFragment
import dev.elvir.morecommunication.ui.chat_create_way.ChatCreateWayFragmentScreen
import dev.elvir.morecommunication.ui.chat_list_screen.adapter.ChatListAdapter
import dev.elvir.morecommunication.ui.search.SearchFragment
import kotlinx.android.synthetic.main.fmt_chat_list_screen.*
import javax.inject.Inject


class ChatListScreenFragment :
    BaseFragment(),
    ChatListContract.ChatListMvpView,
    ChatCreateWayFragmentScreen.CallBack,
    ChatListAdapter.Callback {

    @Inject
    lateinit var presenter: ChatListContract.ChatListMvpPresenter

    companion object {
        fun newInstance() = ChatListScreenFragment()
    }

    lateinit var adapter: ChatListAdapter

    private var listChat: MutableList<Chat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBaseActivity()?.getActivityComponent()?.inject(this)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fmt_chat_list_screen, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        presenter.fetchData()
        iv_create_chat.setOnClickListener {
            val fragment =
                ChatCreateWayFragmentScreen.newInstance().also { it.registerCallback(this) }
            fragment.show(activity!!.supportFragmentManager, "")
        }
    }

    private fun setUpRecycler() {
        rv_chat_list.layoutManager = LinearLayoutManager(context!!)
        adapter = ChatListAdapter(this)
        rv_chat_list.adapter = adapter
    }

    override fun selected(type: Int) {
        startActivity(Intent(context, SearchFragment::class.java))
    }

    override fun showChatList(list: MutableList<Chat>) {
        adapter.list = list
    }

    override fun selectedItem(chat: Chat) {
        val intent = Intent(context, ChatScreenFragment::class.java)
        intent.putExtra(CHAT_KEY, chat.chatId)
        startActivity(intent)
    }


}