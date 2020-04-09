package dev.elvir.morecommunication.ui.splas_screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.user.AuthState
import dev.elvir.morecommunication.data.repository.AuthRepository
import dev.elvir.morecommunication.di.component.DaggerActivityComponent
import dev.elvir.morecommunication.di.module.ActivityModule
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.main_menu_screen.MainMenuActivity
import dev.elvir.morecommunication.ui.sign_in_mode.SignInModeScreenActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.naiksoftware.stomp.StompClient
import javax.inject.Inject

@SuppressLint("CheckResult")
class SplashScreenActivity : BaseActivity(), SplashContract.SplashView {

    @Inject
    lateinit var presenter: SplashContract.SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash_screen)
        getActivityComponent().inject(this)
        presenter.onAttach(this)
        presenter.checkVersion()
    }

    override fun goToSignInMode() {
        startActivity(Intent(this, SignInModeScreenActivity::class.java))
    }

    override fun goToMainMenu() {
        startActivity(Intent(this, MainMenuActivity::class.java))

    }

}