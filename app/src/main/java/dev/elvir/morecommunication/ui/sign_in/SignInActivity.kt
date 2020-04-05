package dev.elvir.morecommunication.ui.sign_in

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.main_menu_screen.MainMenuActivity
import kotlinx.android.synthetic.main.act_sign_in_screen.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_sign_in_screen)
        btn_enter_sign_in.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }
    }

}