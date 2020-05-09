package week3

import io.reactivex.Observable

fun main() {

    Observable.just(1, 2, 3, 4, 5, 6, 7)
        // * case : 1
        // * 2개를 읽고 나서 앞에서 부터 1개를 제외시킨다(Skip).
//            .buffer(2)
        // * case : 2
        // * 2개를 읽고 나서 앞에서 부터 3개를 제외시킨다.
//            .buffer(2, 1)
        // * case : 3
        // * 2개씩 쪼갠 다음, 쪼갠 덩어리 2개씩 묶고 3개씩 스킵
        // ! buffer가 2개인 경우, buffer된것을 buffer 작업을 한다
        // ! 마지막에는 count가 채워지지 않았음에도 나머지 부분을 출력하는 모습을 보인다.
        .buffer(2)
        .buffer(2, 3)
        .subscribe {
            println("$it")
        }

    Thread.sleep(1000)

}