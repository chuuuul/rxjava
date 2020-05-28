package com.chul.rxmvvm.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.chul.rxmvvm.R
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.merge
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_naver_movie_search.*
import java.util.concurrent.TimeUnit

class NaverMovieSearchActivity : AppCompatActivity(R.layout.activity_naver_movie_search) {

    private val backPressSubject = BehaviorSubject.createDefault(0L)

    private val compositeDisposable = CompositeDisposable()
    private val adapter = NaverMovieSearchAdapter()
    private val viewModel = NaverMovieSearchViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        onClickBackKey()
    }

    private fun onClickBackKey() {
        backPressSubject.subscribeOn(AndroidSchedulers.mainThread())
            .buffer(2, 1)
            .subscribe {
                if (it[1] - it[0] < 1500L) {
                    super.onBackPressed()
                } else {
                    Toast.makeText(this, "종료하려면 한번 더 누르세요", Toast.LENGTH_SHORT).show()
                }
            }.addTo(compositeDisposable)
    }

    private fun initView() {
        rv_content.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    private fun bindViewModel() {

        val changeKeyword = RxTextView.textChanges(et_input)
            .subscribeOn(AndroidSchedulers.mainThread())
            .map { it.toString() }
            .debounce(1000L, TimeUnit.MILLISECONDS, Schedulers.computation())


        val searchClick = RxView.clicks(btn_search)
            .map { et_input.text.toString() }


        listOf(searchClick, changeKeyword)
            .merge()
            .throttleFirst(1000L, TimeUnit.MILLISECONDS)
            .filter(String::isNotBlank)
            .subscribe(viewModel::searchMovie)
            .addTo(compositeDisposable)

        viewModel.errorSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::showErrorToast)
            .addTo(compositeDisposable)

        viewModel.loadingSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pb_loading.isVisible = it }
            .addTo(compositeDisposable)

        viewModel.movieSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(adapter::resetAll)
            .addTo(compositeDisposable)
    }

    private fun showErrorToast(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        unbindViewModel()
        super.onPause()
    }

    private fun unbindViewModel() {
        compositeDisposable.clear()
        viewModel.unbindViewModel()
    }

    override fun onBackPressed() {
        backPressSubject.onNext(System.currentTimeMillis())
    }

}
