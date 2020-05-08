package week4

import io.reactivex.Observable

fun main()
{
    Observable.just(1,2,3,4,5)
//            .skip(2)
            .skipLast(2 )
            .subscribe{ println(it) }
}