package com.example.rx_in_android.rx_bus

import io.reactivex.subjects.BehaviorSubject

object RxBus {

    val publishSubject = BehaviorSubject.create<RxBusEvent>()

    inline fun <reified T : RxBusEvent> subscribe(crossinline onNext: (T) -> Unit) =
        publishSubject.subscribe {
            onNext(it)
        }

    fun onNext(event: RxBusEvent) {
        publishSubject.onNext(event)

    }
}