package com.example.rx_in_android.rx_bus

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.ofType
import io.reactivex.subjects.BehaviorSubject

object RxBus {

    val behaviorSubject = BehaviorSubject.create<RxBusEvent>()

    inline fun <reified T: RxBusEvent>subscribe(crossinline onNext : (T) -> Unit) : Disposable{
        return behaviorSubject
            .ofType<T>()
            .subscribe{
                onNext(it)
            }
        Collection
    }

    fun onNext(event : RxBusEvent){
        behaviorSubject.onNext(event)
    }


}