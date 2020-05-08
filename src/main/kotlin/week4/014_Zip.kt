package week4

import io.reactivex.Observable
import io.reactivex.functions.BiFunction

fun main() {

    val observable1 = Observable.just("A", "B", "C","D")
    val observable2 = Observable.just(1, 2, 3)

    Observable.zip(
            observable1,
            observable2,
            BiFunction<String, Int, String> { t1, t2 ->
                "$t1 $t2"
            })
            .subscribe {
                println(it)
            }


}