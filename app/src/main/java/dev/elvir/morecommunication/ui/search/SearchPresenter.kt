package dev.elvir.morecommunication.ui.search

import android.annotation.SuppressLint
import dev.elvir.morecommunication.data.network.api.ChatApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

@SuppressLint("CheckResult")
class SearchPresenter(
    val view: SearchFragment,
    val retrofit: Retrofit
) : SearchContract.Presenter {

    override fun search(search: String) {
        retrofit.create(ChatApi::class.java)
            .getSearch(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.updateList(it)
                },
                { it.printStackTrace() }
            )
    }

}