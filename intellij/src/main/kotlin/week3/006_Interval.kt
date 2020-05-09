package week3

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    Observable.interval(100, 500, TimeUnit.MILLISECONDS)
        .subscribe {
            println("$it")
        }

    Thread.sleep(2000)
}