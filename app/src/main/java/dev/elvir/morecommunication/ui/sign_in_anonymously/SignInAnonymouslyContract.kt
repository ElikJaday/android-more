package dev.elvir.morecommunication.ui.sign_in_anonymously

interface SignInAnonymouslyContract {

    interface View {

        fun showSelectImage()
        fun goToMainMenu()

    }

    interface Presenter {

        fun clickEnter(userNickname: String)
        fun clickSelectImage()

    }

}