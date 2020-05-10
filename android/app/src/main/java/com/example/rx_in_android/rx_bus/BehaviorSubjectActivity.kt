package com.example.rx_in_android.rx_bus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rx_in_android.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_behavior_subject.*

class BehaviorSubjectActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_behavior_subject)

        btn_moveToSendActivity.setOnClickListener {
            RxBus.subscribe<SampleDataClass> {
                Log.d("chul", it.text)
            }.addTo(compositeDisposable)
        }

    }


}
