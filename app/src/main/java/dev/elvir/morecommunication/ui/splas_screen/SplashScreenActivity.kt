package dev.elvir.morecommunication.ui.splas_screen

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.sign_in_mode.SignInModeScreenActivity
import ua.naiksoftware.stomp.StompClient


class SplashScreenActivity : BaseActivity(), SplashContract.SplashView {

    private val presenter : SplashContract.SplashPresenter  = SplashPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash_screen)
        presenter.checkVersion()

    }

    override fun goToSignInMode() {
        startActivity(Intent(this, SignInModeScreenActivity::class.java))
    }

}