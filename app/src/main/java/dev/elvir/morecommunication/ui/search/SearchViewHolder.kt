package dev.elvir.morecommunication.ui.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.data.entity.user.UserEntity
import kotlinx.android.synthetic.main.list_item_search_list.view.*

class SearchViewHolder(
    val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        userEntity: UserEntity,
        callback: SearchListAdapter.Callback
    ) {
        val text = view.tv_user_nick_name
        text.text = userEntity.nickName
        view.vg_item_search_list.setOnClickListener {
            callback.selectedItem(userEntity)
        }
    }

}