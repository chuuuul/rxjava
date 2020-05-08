package week4

import io.reactivex.Observable

fun main()
{
    Observable.just(1,"hi",3.14f, arrayListOf(3,5), arrayListOf(1.1, 2.2))
            .ofType(ArrayList::class.java)
            .subscribe { println(it) }

}