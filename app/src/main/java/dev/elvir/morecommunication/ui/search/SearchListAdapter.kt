package dev.elvir.morecommunication.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.user.UserEntity

class SearchListAdapter(
    val listUser: List<UserEntity>,
    val callback: Callback
) : RecyclerView.Adapter<SearchViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_search_list, parent, false)
        )

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) = holder.bind(listUser[position],callback)


    interface Callback{

        fun selectedItem(userEntity: UserEntity)

    }
}