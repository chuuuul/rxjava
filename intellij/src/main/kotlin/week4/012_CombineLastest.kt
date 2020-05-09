package week4

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
import kotlin.random.Random

fun main() {

    val observable1 = Observable.interval(200, TimeUnit.MILLISECONDS)

    val observable2 = Observable.interval(100, TimeUnit.MILLISECONDS)
        .map { Random.nextInt(10) }

    Observable.combineLatest(
        observable1,
        observable2,
        BiFunction<Long, Int, String> { t1, t2 ->
            "$t1 $t2"
        })
        .subscribe {
            println(it)
        }

    Thread.sleep(2000)


}