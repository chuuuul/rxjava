package week3

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(){

    Observable.range(0,5)
            .subscribe{
                println("$it")
                Thread.sleep(300)
            }

    Thread.sleep(2000)
}