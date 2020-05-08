package week4

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(){

    Observable.interval(500, TimeUnit.MILLISECONDS)
            // * case 1
            .debounce( 300, TimeUnit.MILLISECONDS)
            // * case 2
//            .debounce( 600, TimeUnit.MILLISECONDS)
            .subscribe{
                println(it)
            }



    Thread.sleep(5000)

}