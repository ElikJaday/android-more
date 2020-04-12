package dev.elvir.morecommunication.ui.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private var baseActivity: BaseActivity? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.baseActivity = context
        }
    }
      fun getBaseActivity():BaseActivity? = baseActivity

}