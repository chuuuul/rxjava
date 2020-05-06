package week3

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

fun main() {

    Observable.just(1, 2, 3)
            .repeat(5)
            .subscribe(
                    { println("$it") },
                    { println("on Error") },
                    { println("onComplete") }
            )

    // * 반복할때 onComplete는 실행되지 않는다..

    Thread.sleep(3000)
}