package dev.elvir.morecommunication.ui.news_list_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.model.User

class NewsListAdapter(
    val listUser: MutableList<User>
) : RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_news_list, parent, false)
        )

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {

    }

}