package dev.elvir.morecommunication.ui.chat_list_screen

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.model.User
import dev.elvir.morecommunication.data.model.UserType
import dev.elvir.morecommunication.ui.chat.ChatScreenFragment
import dev.elvir.morecommunication.ui.main_menu_screen.MainMenuActivity
import kotlinx.android.synthetic.main.fmt_chat_list_screen.*


class ChatListScreenFragment : Fragment(){

    var listUser : MutableList<User> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fmt_chat_list_screen,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChatList()
        rv_chat_list.layoutManager = LinearLayoutManager(context!!)
        rv_chat_list.adapter = ChatListAdapter(listUser)
    }

    fun addChatList(){
//        listUser.add(User("Elvir Ibrahimov","","",UserType.ANONYMOUSLY))
//        listUser.add(User("Elvir Ibrahimov","","",UserType.ANONYMOUSLY))
//        listUser.add(User("Elvir Ibrahimov","","",UserType.ANONYMOUSLY))

    }

    companion object {
        fun newInstance() = ChatListScreenFragment()
    }
}