package week4

import io.reactivex.Observable

fun main() {

    val observable = Observable.just(1, 2, 3)

    val completable = observable.ignoreElements()
    completable.subscribe { println("It is completable") }
}