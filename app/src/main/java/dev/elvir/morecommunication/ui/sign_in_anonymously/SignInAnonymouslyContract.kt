package dev.elvir.morecommunication.ui.sign_in_anonymously

import android.provider.ContactsContract
import dev.elvir.morecommunication.data.entity.user.UserEntity

class SignInAnonymouslyContract {

    interface View{

        fun showSelectImage()
        fun goToMainMenu()
    }

    interface Presenter{
        fun clickEnter(userNickname: String)
        fun clickSelectImage()
    }
}