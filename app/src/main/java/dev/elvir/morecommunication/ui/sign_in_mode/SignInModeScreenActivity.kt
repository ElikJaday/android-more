package dev.elvir.morecommunication.ui.sign_in_mode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.sign_in.SignInActivity
import dev.elvir.morecommunication.ui.sign_in_anonymously.SignInAnonymouslyScreenActivity
import kotlinx.android.synthetic.main.activity_sign_in_mode_screen.*

class SignInModeScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorMainLogo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_mode_screen)
        btn_enter_anonymously.setOnClickListener {
            startActivity(Intent(this, SignInAnonymouslyScreenActivity::class.java))
        }
        btn_enter_sign_in.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
