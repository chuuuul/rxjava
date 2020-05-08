package week4

import io.reactivex.Observable

fun main() {

    val observable1 = Observable.range(1, 3)
    val observable2 = Observable.range(4, 3)
    val observable3 = Observable.just('가','나','다')

    val merge1 = Observable.merge(observable1, observable2)
    val merge2 = Observable.merge(merge1, observable3)

    merge1.subscribe {
        println(it)
    }

    merge2.subscribe {
        println(it)
    }
}