package week4

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


fun main() {

    Observable.interval(1000, TimeUnit.MILLISECONDS)
        .timeout(500, TimeUnit.MILLISECONDS)
        .subscribe(
            {
                println(it)
            },
            { println("TimeOut!!") }
        )

    Thread.sleep(1000)
}