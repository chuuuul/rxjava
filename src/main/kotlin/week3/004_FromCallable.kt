package week3

import io.reactivex.Observable


fun main() {
    val observable = Observable
            .fromCallable { doSomething() }

    observable.subscribe { println(it) }
    Thread.sleep(1000)
    observable.subscribe { println(it) }
    Thread.sleep(1000)
}

fun doSomething(): String {
    println( System.currentTimeMillis().toString() )

    return "This is Callable"
}