package dev.elvir.morecommunication.ext

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@JvmOverloads
public fun <T> Observable<T>.ioToMain(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

@JvmOverloads
public fun <T> Single<T>.ioToMain(): Single<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

@JvmOverloads
public fun <T> Flowable<T>.ioToMain(): Flowable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

@JvmOverloads
public fun <T> Maybe<T>.ioToMain(): Maybe<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}


@JvmOverloads
public fun <T> Observable<T>.computationToMain(): Observable<T> {
    return this.subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
}

@JvmOverloads
public fun <T> Single<T>.computationToMain(): Single<T> {
    return this.subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
}

@JvmOverloads
public fun <T> Flowable<T>.computationToMain(): Flowable<T> {
    return this.subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
}


@JvmOverloads
public fun <T> Maybe<T>.computationToMain(): Maybe<T> {
    return this.subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
}