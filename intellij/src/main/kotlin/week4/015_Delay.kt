package week4

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    Observable.just(1, 2, 3)
        .delay(1000, TimeUnit.MILLISECONDS)
        .subscribe {
            println(it)
        }

    Thread.sleep(1500)
}