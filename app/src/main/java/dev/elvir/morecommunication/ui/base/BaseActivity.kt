package dev.elvir.morecommunication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.di.component.ActivityComponent
import dev.elvir.morecommunication.di.component.DaggerActivityComponent
import dev.elvir.morecommunication.di.module.ActivityModule

open abstract class BaseActivity : AppCompatActivity() {

    lateinit var daggerActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerActivityComponent = DaggerActivityComponent.builder()
            .appComponent((applicationContext as App).appComponent)
            .activityModule(ActivityModule(this))
            .build()
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorMainLogo)
    }

    fun getActivityComponent():
            ActivityComponent = daggerActivityComponent
}
