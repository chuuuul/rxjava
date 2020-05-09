package week4

import io.reactivex.Observable

fun main() {

    Observable.just(1, 2, 3, 3, 2, 1)
        .distinctUntilChanged()
        .subscribe { println(it) }

}