package week4

import io.reactivex.Observable


fun main(){

    Observable.just(1,2,3,4,5)
//            .take(2)
            .takeLast(2)
            .subscribe{ println(it) }

}