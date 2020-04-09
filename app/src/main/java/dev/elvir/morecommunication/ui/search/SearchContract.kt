package dev.elvir.morecommunication.ui.search

import dev.elvir.morecommunication.data.entity.user.UserEntity

interface SearchContract {

    interface View{

        fun updateList(userList: List<UserEntity>)

    }

    interface Presenter{

        fun search(it: String)

    }

}