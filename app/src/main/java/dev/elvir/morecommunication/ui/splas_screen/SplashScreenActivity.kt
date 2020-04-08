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
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.sign_in_mode.SignInModeScreenActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.naiksoftware.stomp.StompClient
import javax.inject.Inject

@SuppressLint("CheckResult")
class SplashScreenActivity : BaseActivity(), SplashContract.SplashView {

    private val presenter : SplashContract.SplashPresenter  = SplashPresenter(this)

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        authRepository.getAuthEntity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               if (it.authState == AuthState.ACTIVATED){
                   Log.e("Info","true")
               }else{
                   Log.e("Info","false")

               }
            },{it.printStackTrace()})
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash_screen)
        presenter.checkVersion()


    }

    override fun goToSignInMode() {
        startActivity(Intent(this, SignInModeScreenActivity::class.java))
    }

}