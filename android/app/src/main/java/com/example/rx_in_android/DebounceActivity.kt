package com.example.rx_in_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_debounce.*
import java.util.concurrent.TimeUnit

class DebounceActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val publishSubject = PublishSubject.create<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debounce)

        publishSubject
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(1000, TimeUnit.MILLISECONDS)
            .subscribe {
                tv_output.text = it
            }
            .addTo(compositeDisposable)

        et_input.doOnTextChanged { text, _, _, _ ->
            publishSubject.onNext(text.toString())
        }

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
