package week3

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {

    Observable.timer(0, TimeUnit.MILLISECONDS, Schedulers.newThread())
        .subscribe { println("$it") }

    Thread.sleep(3000)

}