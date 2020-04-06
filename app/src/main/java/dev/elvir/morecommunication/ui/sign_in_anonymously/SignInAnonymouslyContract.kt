package dev.elvir.morecommunication.ui.sign_in_anonymously

class SignInAnonymouslyContract {

    interface View{

        fun showSelectImage()

    }

    interface Presenter{
        fun clickEnter()
        fun clickSelectImage()
    }
}