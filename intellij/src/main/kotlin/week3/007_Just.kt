package week3

import io.reactivex.Observable

fun main() {

    Observable.just('a', 'b', 'c')
        .subscribe { println(it) }

}