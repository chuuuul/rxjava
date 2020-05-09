package week3

import io.reactivex.Observable

fun main() {

    Observable.just(1, 2, 3, 4, 5, 6, 7)
        .flatMap { Observable.just("$it Hello", "$it Hi") }
        .subscribe { println(it) }
}