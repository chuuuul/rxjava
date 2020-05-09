package com.example.rx_in_android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject

class BufferActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val behaviorSubject = BehaviorSubject.createDefault(0L)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buffer)

        behaviorSubject.buffer(2, 1)
            .subscribe {
                val timeDelta = it[1] - it[0]

                if (timeDelta < 1500L) {
                    super.onBackPressed()
                } else {
                    Toast.makeText(this, "뒤로가기를 한번 더 누를 시 종료됩니다.", Toast.LENGTH_SHORT).show()
                }
            }
            .addTo(compositeDisposable)

    }

    override fun onBackPressed() {
        behaviorSubject.onNext(System.currentTimeMillis())
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
