package week4

import io.reactivex.Observable

fun main(){

    Observable.just(1,2,3)
            .startWith(0)
            .startWith(-1)
            .subscribe{
                println(it)
            }
}