package dev.elvir.morecommunication.ui.news_list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fmt_news_list_screen.*
import javax.inject.Inject

class NewsListScreenFragment : BaseFragment(),
    NewsListContract.NewsListMvpView {
    @Inject
    lateinit var presenter: NewsListContract.NewsListMvpPresenter

    var listUser: MutableList<UserEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBaseActivity()?.getActivityComponent()?.inject(this)
        presenter.onAttach(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fmt_news_list_screen, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChatList()
        rv_news_list.layoutManager = LinearLayoutManager(context!!)
        rv_news_list.adapter = NewsListAdapter(listUser)


    }

    fun addChatList() {
//        listUser.add(User("Elvir Ibrahimov"))
//        listUser.add(User("Elmar Ibrahimov "))
//        listUser.add(User("Shamil  Efendiyev"))
//        listUser.add(User("Jale Ibrahimove"))
    }

    companion object {
        fun newInstance() = NewsListScreenFragment()
    }

}