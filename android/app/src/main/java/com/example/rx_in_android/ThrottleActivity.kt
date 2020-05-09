package com.example.rx_in_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_throttle.*
import java.util.concurrent.TimeUnit

class ThrottleActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val publishSubject = PublishSubject.create<Unit>()
    private var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_throttle)

        publishSubject.subscribeOn(Schedulers.newThread())
            .throttleFirst(1000, TimeUnit.MILLISECONDS)
            .subscribe {
                num++
                tv_output.text = num.toString()
            }.addTo(compositeDisposable)

        btn_increase.setOnClickListener {
            publishSubject.onNext(Unit)
        }

    }


    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
