package week3

import io.reactivex.Observable


fun main() {

    Observable.just(1, 2, 3, 4, 5, 6, 7)
            .switchMap{
                Observable.just("First work - $it ", "Second work - $it")
            }
            .subscribe{
                println(it)
            }

    Thread.sleep(3000)
}