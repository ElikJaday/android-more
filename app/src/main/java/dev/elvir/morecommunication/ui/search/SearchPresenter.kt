package dev.elvir.morecommunication.ui.search

import android.annotation.SuppressLint
import dev.elvir.morecommunication.data.interactor.SearchInteractor
import dev.elvir.morecommunication.data.network.api.ChatApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

@SuppressLint("CheckResult")
class SearchPresenter @Inject constructor(
    val searchInteractor: SearchInteractor
) : SearchContract.SearchMvpPresenter {
    private var mvpView: SearchContract.SearchMvpView? = null


    override fun search(search: String) {
        searchInteractor
            .searchUsers(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mvpView?.updateList(it)
                },
                { it.printStackTrace() }
            )
    }

    override fun onAttach(view: SearchContract.SearchMvpView) {
        this.mvpView = mvpView
    }

}