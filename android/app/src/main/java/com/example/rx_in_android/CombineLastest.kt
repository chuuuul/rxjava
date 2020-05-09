package com.example.rx_in_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.combineLatest
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_combine_lastest.*

class CombineLastest : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private val nameBehaviorSubject = BehaviorSubject.createDefault("")
    private val ageBehaviorSubject = BehaviorSubject.createDefault("")
    private val addressBehaviorSubject = BehaviorSubject.createDefault("")

//    private val publishSubject = PublishSubject.create<Unit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combine_lastest)

        et_name.doOnTextChanged { text, _, _, _ ->
            nameBehaviorSubject.onNext(text.toString())
        }

        et_age.doOnTextChanged { text, _, _, _ ->
            ageBehaviorSubject.onNext(text.toString())
        }

        et_address.doOnTextChanged { text, _, _, _ ->
            addressBehaviorSubject.onNext(text.toString())
        }

        listOf(nameBehaviorSubject, ageBehaviorSubject, addressBehaviorSubject)
            .combineLatest {
                it.fold(true, { t1, t2 -> t1 && t2.isNotEmpty() })
            }.subscribe {
                btn_combine_submit.isEnabled = it
            }.addTo(compositeDisposable)


    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
