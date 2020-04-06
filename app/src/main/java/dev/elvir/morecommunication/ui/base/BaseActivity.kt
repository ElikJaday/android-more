package dev.elvir.morecommunication.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.elvir.morecommunication.R

open class BaseActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorMainLogo)
    }

}
