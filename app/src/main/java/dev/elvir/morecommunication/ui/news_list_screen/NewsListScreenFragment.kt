package dev.elvir.morecommunication.ui.news_list_screen

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.model.User
import dev.elvir.morecommunication.ui.chat.ChatScreenFragment
import dev.elvir.morecommunication.ui.chat_list_screen.ChatListAdapter
import dev.elvir.morecommunication.ui.main_menu_screen.MainMenuActivity
import kotlinx.android.synthetic.main.fmt_chat_list_screen.*
import kotlinx.android.synthetic.main.fmt_news_list_screen.*

class NewsListScreenFragment  : Fragment(){

    var listUser : MutableList<User> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          return inflater.inflate(R.layout.fmt_news_list_screen,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChatList()
        rv_news_list.layoutManager = LinearLayoutManager(context!!)
        rv_news_list.adapter = NewsListAdapter(listUser)




    }

    fun addChatList(){
        listUser.add(User("Elvir Ibrahimov"))
        listUser.add(User("Elmar Ibrahimov "))
        listUser.add(User("Shamil  Efendiyev"))
        listUser.add(User("Jale Ibrahimove"))
    }

    companion object {
        fun newInstance() = NewsListScreenFragment()
    }

}