package com.chul.rxmvvm.activity

import com.chul.rxmvvm.model.NaverMovieResponse
import com.chul.rxmvvm.retrofit.NetworkManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class NaverMovieSearchViewModel {

    private val compositeDisposable = CompositeDisposable()

    val movieSubject = BehaviorSubject.create<List<NaverMovieResponse.Item>>()
    val loadingSubject = BehaviorSubject.createDefault(false)
    val errorSubject = BehaviorSubject.create<Throwable>()


    fun searchMovie(query: String) {
        NetworkManager.naverApi.getMovieList(query)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { loadingSubject.onNext(true) }
            .doAfterTerminate { loadingSubject.onNext(false) }
            .map { it.items }
            .subscribe(
                movieSubject::onNext,
                errorSubject::onNext
            )
            .addTo(compositeDisposable)
    }

    fun unbindViewModel() {
        compositeDisposable.clear()
    }

}