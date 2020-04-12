package dev.elvir.morecommunication.ui.search

import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.ui.base.Presenter

interface SearchContract {

    interface SearchMvpView{

        fun updateList(userList: List<UserEntity>)

    }

    interface SearchMvpPresenter:Presenter<SearchMvpView>{

        fun search(it: String)

    }

}