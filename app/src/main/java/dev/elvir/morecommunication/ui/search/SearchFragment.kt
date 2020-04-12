package dev.elvir.morecommunication.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.morecommunication.App
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.user.UserEntity
import dev.elvir.morecommunication.ui.base.BaseActivity
import dev.elvir.morecommunication.ui.chat.CHAT_KEY
import dev.elvir.morecommunication.ui.chat.ChatScreenFragment
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.ac_search.*
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@SuppressLint("CheckResult")
class SearchFragment : BaseActivity(), SearchContract.SearchMvpView, SearchListAdapter.Callback {


    @Inject
    lateinit var presenter: SearchContract.SearchMvpPresenter
    private val disposable = CompositeDisposable()
    private val subject = BehaviorSubject.create<String>()
    private val textInput = subject.toFlowable(BackpressureStrategy.LATEST)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityComponent().inject(this)
        presenter.onAttach(this)
        setContentView(R.layout.ac_search)
        setUpListener()
    }

    private fun setUpListener() {
        et_search_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                subject.onNext(et_search_text.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        disposable.add(
            textInput
                .debounce(300, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    presenter.search(it)
                }
        )
    }

    override fun updateList(userList: List<UserEntity>) {
        rv_search.layoutManager = LinearLayoutManager(this)
        rv_search.adapter = SearchListAdapter(userList, this)
    }

    override fun selectedItem(userEntity: UserEntity) {
        val intent = Intent(this, ChatScreenFragment::class.java)
        intent.putExtra(CHAT_KEY, userEntity.uid)
        startActivity(intent)
    }
}