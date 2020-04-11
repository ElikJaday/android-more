package dev.elvir.morecommunication.ui.sign_in_mode

import android.content.Intent
import android.os.Bundle
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.sign_in.SignInActivity
import dev.elvir.morecommunication.ui.sign_in_anonymously.SignInAnonymouslyScreenActivity
import kotlinx.android.synthetic.main.activity_sign_in_mode_screen.*
import javax.inject.Inject

class SignInModeScreenActivity :
    BaseActivity(), SignInModeContract.SignInModeMvpView {
    @Inject
    lateinit var signInModeMvpPresenter: SignInModeContract.SignInModeMvpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_mode_screen)
        getActivityComponent().inject(this)
        signInModeMvpPresenter.onAttach(this)
        with(btn_enter_sign_in) {
            background = resources.getDrawable(R.drawable.btn_background_full_disable)
            isEnabled = false
        }
        btn_enter_anonymously.setOnClickListener { goToSignInAnonymouslyScreen() }
        btn_enter_sign_in.setOnClickListener { goToSignInScreen() }
    }

    override fun goToSignInAnonymouslyScreen() =
        startActivity(Intent(this, SignInAnonymouslyScreenActivity::class.java))

    override fun goToSignInScreen() =
        startActivity(Intent(this, SignInActivity::class.java))

}
