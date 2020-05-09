package week4

import io.reactivex.Observable

fun main() {
    Observable.just(1, 2, 3, 4, 5)
        .filter { it > 2 }
        .subscribe {
            println(it)
        }
}