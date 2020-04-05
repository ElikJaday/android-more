package dev.elvir.morecommunication.ui.sign_in_mode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.elvir.morecommunication.R
import kotlinx.android.synthetic.main.activity_sign_in_mode_screen.*

class SignInModeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_mode_screen)
        btn_enter_anonymously.setOnClickListener {  }
        btn_enter_sign_in.setOnClickListener {  }
    }
}
