package dev.elvir.morecommunication.ui.sign_in_anonymously

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.api.AuthApi
import dev.elvir.morecommunication.data.model.User
import dev.elvir.morecommunication.data.model.UserImage
import dev.elvir.morecommunication.data.model.UserType
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.main_menu_screen.MainMenuActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_sign_in_anonymously_screen.*
import retrofit2.Retrofit
import javax.inject.Inject


@SuppressLint("CheckResult")
class SignInAnonymouslyScreenActivity : BaseActivity() {

    @Inject
    lateinit var retrofit: Retrofit
    lateinit var byteArray: ByteArray

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorMainLogo)
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_anonymously_screen)
        btn_enter.setOnClickListener {
            sendRequest()
        }
        iv_choose.setOnClickListener {
            getImageFromMediaProvider()
        }


    }

    fun getImageFromMediaProvider() {
        val pickPhoto = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(pickPhoto, 1) //one can be replaced with any action code

    }

    fun getImageFromCamera() {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePicture, 0)
    }


    private fun sendRequest() {
        retrofit.create(AuthApi::class.java)
            .authAnonymously(
                User(
                    "Elvir Ibrahimov",
                    "@ElikJaday",
                    "+79168867925",
                    UserType.ANONYMOUSLY,
                    UserImage("example", "jpeg", byteArray)
                )
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { startActivity(Intent(this, MainMenuActivity::class.java)) },
                { it.printStackTrace() }
            )
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> {
                var uri = data?.data
                iv_choose.setImageURI(uri)
            }
            1 -> {
                var uri = data?.data
                iv_choose.setImageURI(uri)
                byteArray = contentResolver.openInputStream(uri!!)?.readBytes()!!
            }
        }
    }

}
