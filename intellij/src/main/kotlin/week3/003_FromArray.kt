package week3

import io.reactivex.Observable

fun main() {

    val array = arrayOf("hi", "Hello")

    Observable.fromArray(*array)
        .subscribe { println(it) }


    Thread.sleep(2000)
}