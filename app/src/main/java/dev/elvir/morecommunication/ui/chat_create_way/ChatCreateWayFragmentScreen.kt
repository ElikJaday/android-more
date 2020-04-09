package dev.elvir.morecommunication.ui.chat_create_way

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.ui.custom_ui.ExpandedBottomSheetDialogFragment
import kotlinx.android.synthetic.main.fmt_chat_create_way.*

const val SELECT_RADAR = 0
const val SELECT_ADRESS_BOOK = 1
const val SELECT_SEARCH = 2

class ChatCreateWayFragmentScreen : ExpandedBottomSheetDialogFragment() {

    companion object {
        fun newInstance() = ChatCreateWayFragmentScreen()
    }

    lateinit var callBack: ChatCreateWayFragmentScreen.CallBack

    fun registerCallback(callBack: ChatCreateWayFragmentScreen.CallBack) {
        this.callBack = callBack
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fmt_chat_create_way, container, false);


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vg_radar.setOnClickListener {
            callBack.selected(SELECT_RADAR)
            dismiss()
        }
        vg_address_book.setOnClickListener {
            callBack.selected(SELECT_ADRESS_BOOK)
            dismiss()
        }
        vg_address_book.setOnClickListener {
            callBack.selected(SELECT_SEARCH)
            dismiss()
        }
    }

    interface CallBack {
        fun selected(type: Int)
    }

}