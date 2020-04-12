package dev.elvir.morecommunication.ui.news_list_screen

import dev.elvir.morecommunication.data.interactor.NewsListInteractor
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
    private val newsListInteractor: NewsListInteractor) :
    NewsListContract.NewsListMvpPresenter {
    private var mvpView: NewsListContract.NewsListMvpView? = null


    override fun onAttach(view: NewsListContract.NewsListMvpView) {
        this.mvpView = view
    }
}