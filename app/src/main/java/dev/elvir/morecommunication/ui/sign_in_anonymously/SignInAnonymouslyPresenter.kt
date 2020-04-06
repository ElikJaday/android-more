package dev.elvir.morecommunication.ui.sign_in_anonymously

class SignInAnonymouslyPresenter(
    val view: SignInAnonymouslyContract.View
) : SignInAnonymouslyContract.Presenter {

    override fun clickEnter() {
        TODO("Not yet implemented")
    }

    override fun clickSelectImage() {
        view.showSelectImage()
    }

}