package com.chul.rxmvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.chul.rxmvvm.R
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.merge
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_naver_movie_search.*
import java.util.concurrent.TimeUnit

class NaverMovieSearchActivity : AppCompatActivity(R.layout.activity_naver_movie_search) {

    private val compositeDisposable = CompositeDisposable()

    private val adapter = NaverMovieSearchAdapter()
    private val vm by lazy {
        NaverMovieSearchViewModel()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        btn_search.setOnClickListener {
            vm.searchMovie(et_input.text.toString())

        }
    }

    private fun bindViewModel() {
        val textChange = RxTextView.textChangeEvents(et_input)
            .debounce(2000L, TimeUnit.MILLISECONDS, Schedulers.computation())
            .map { it.text().toString() }

        val searchClick = RxView.clicks(btn_search)
            .map { et_input.text.toString() }

        listOf(textChange, searchClick)
            .merge()
            .throttleFirst(500L, TimeUnit.MILLISECONDS)
            .filter(String::isNotBlank)
            .subscribe(vm::searchMovie)
            .addTo(compositeDisposable)

        vm.errorSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    this::showError
            ).addTo(compositeDisposable)

        vm.loadingSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pb_loading.isVisible = it }
            .addTo(compositeDisposable)

        vm.movieSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                adapter::resetAll
            ).addTo(compositeDisposable)

    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    override fun onPause() {
        unbindViewModel()
        super.onPause()
    }

    private fun unbindViewModel() {
        compositeDisposable.clear()
        vm.unBindViewModel()
    }

    private fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }


    private fun initView() {
        rv_content.adapter = adapter
    }


}
