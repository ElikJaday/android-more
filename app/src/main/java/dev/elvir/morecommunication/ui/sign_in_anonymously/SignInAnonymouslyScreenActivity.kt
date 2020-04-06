package dev.elvir.morecommunication.ui.sign_in_anonymously

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.tedpark.tedpermission.rx2.TedRx2Permission
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.select_image.SELECT_CAPTURE
import dev.elvir.morecommunication.ui.select_image.SELECT_MEDIA
import dev.elvir.morecommunication.ui.select_image.SelectImageFragmentScreen
import kotlinx.android.synthetic.main.activity_sign_in_anonymously_screen.*


class SignInAnonymouslyScreenActivity :
    BaseActivity(), SignInAnonymouslyContract.View, SelectImageFragmentScreen.CallBack {

    val presenter: SignInAnonymouslyContract.Presenter = SignInAnonymouslyPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_anonymously_screen)
        addWidgetListener()
    }

    fun addWidgetListener() {
        iv_choose.setOnClickListener {
            TedRx2Permission.with(this)
                .setPermissions(Manifest.permission.CAMERA)
                .request()
                .subscribe (
                    {
                        presenter.clickSelectImage()
                    },
                    {}
                )
        }
    }

    override fun showSelectImage() {
        val fragment = SelectImageFragmentScreen.newInstance().also { it.registerCallback(this) }
        fragment.show(supportFragmentManager, "")
    }

    override fun selected(type: Int) {
        when (type) {
            SELECT_CAPTURE -> {
                val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePicture, SELECT_CAPTURE)
            }
            SELECT_MEDIA -> {
                val getIntent = Intent(Intent.ACTION_GET_CONTENT)
                getIntent.type = "image/*"
                val pickIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                pickIntent.type = "image/*"
                val chooserIntent = Intent.createChooser(getIntent, "Select Image")
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))
                startActivityForResult(chooserIntent, SELECT_MEDIA)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            SELECT_CAPTURE -> {
                val bitmap : Bitmap? = data?.extras?.get("data") as Bitmap?
                iv_choose.setImageBitmap(bitmap)
            }
            SELECT_MEDIA -> {
                val uri: Uri? = data?.data
                iv_choose.setImageURI(uri)
            }
        }
    }

}
