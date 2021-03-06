package week4

import io.reactivex.Observable

fun main() {

    Observable.just("Data1", "Data2")
        .doOnNext { println("doOnNext") }
            .doOnSubscribe { println("doOnSubscribe") }
            .doAfterNext { println("doAfterNext") }
            .doAfterTerminate { println("doAfterTerminate") }
            .doFinally { println("doFinally") }
            .doOnComplete { println("doOnComplete") }
            .doOnDispose { println("doOnDispose") }
            .doOnEach { println("doOnEach") }
            .doOnError { println("doOnError") }
            .doOnTerminate { println("doOnTerminate") }
            .subscribe { println("- $it") }

    /*
     * ==== Result ====
     *
     * doOnSubscribe
     * doOnNext
     * doOnEach
     * - Data1
     * doAfterNext
     * doOnNext
     * doOnEach
     * - Data2
     * doAfterNext
     * doOnComplete
     * doOnEach
     * doOnTerminate
     * doFinally
     * doAfterTerminate
     *
     * Process finished with exit code 0


     */
}