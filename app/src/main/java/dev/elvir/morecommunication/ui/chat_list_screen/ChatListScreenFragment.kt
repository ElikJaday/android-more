package dev.elvir.morecommunication.ui.chat_list_screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.ui.chat_create_way.ChatCreateWayFragmentScreen
import dev.elvir.morecommunication.ui.search.SearchFragment
import dev.elvir.morecommunication.ui.select_image.SelectImageFragmentScreen
import kotlinx.android.synthetic.main.fmt_chat_list_screen.*


class ChatListScreenFragment : Fragment(), ChatCreateWayFragmentScreen.CallBack {

    companion object {
        fun newInstance() = ChatListScreenFragment()
    }

    var listUser: MutableList<UserEntity> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fmt_chat_list_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_chat_list.layoutManager = LinearLayoutManager(context!!)
        rv_chat_list.adapter = ChatListAdapter(listUser)
        iv_create_chat.setOnClickListener {
            val fragment = ChatCreateWayFragmentScreen.newInstance().also { it.registerCallback(this) }
            fragment.show(activity!!.supportFragmentManager, "")
        }
    }

    override fun selected(type: Int) {
        startActivity(Intent(context,SearchFragment::class.java))
    }

}