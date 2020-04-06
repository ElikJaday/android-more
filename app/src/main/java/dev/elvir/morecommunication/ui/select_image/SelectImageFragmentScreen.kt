package dev.elvir.morecommunication.ui.select_image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.custom_ui.ExpandedBottomSheetDialogFragment
import kotlinx.android.synthetic.main.fmt_select_image.*

const val SELECT_CAPTURE = 0
const val SELECT_MEDIA = 1


class SelectImageFragmentScreen : ExpandedBottomSheetDialogFragment() {
    lateinit var callBack: CallBack

    companion object {
        fun newInstance() = SelectImageFragmentScreen()
    }

    fun registerCallback(callBack: CallBack) {
        this.callBack = callBack
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fmt_select_image, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vg_capture.setOnClickListener {
            callBack.selected(SELECT_CAPTURE)
            dismiss()
        }
        vg_choose.setOnClickListener {
            callBack.selected(SELECT_MEDIA)
            dismiss()
        }
    }

    interface CallBack {
        fun selected(type: Int)
    }
}

