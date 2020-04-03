package dev.elvir.morecommunication.ui.splas_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.sign_in.SignInActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this, SignInActivity::class.java))
        }, 800)
    }
}