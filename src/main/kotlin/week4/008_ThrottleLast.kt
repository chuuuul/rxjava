package week4


import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(){

    Observable.interval(100, TimeUnit.MILLISECONDS)
            .throttleLast( 250, TimeUnit.MILLISECONDS )
            .subscribe{ println(it) }

    Thread.sleep(2000)
}