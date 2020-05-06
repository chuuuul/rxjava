package week3

import io.reactivex.Observable
import java.util.function.BiFunction

fun main() {
    Observable.just("This", " ", "is", " ", "Observable")
            .scan { t1: String, t2: String -> t1+t2 }
            .subscribe { println(it) }

    // * Scan과 다른점음 맨 마지막 연산만 결과가 나옴
    Observable.just("This", " ", "is", " ", "Observable")
            .reduce { t1: String, t2: String -> t1+t2 }
            .subscribe { println(it) }


}
