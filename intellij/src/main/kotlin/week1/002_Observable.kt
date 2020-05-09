import io.reactivex.Observable

/*
* 생산 연산자는 공장
* 변경 연산자는 포장 작업
* 소비자는 소비자..
*
* 각각의 아이템을 공장에서 생산을하고
* 아이템을 포장 용기에 알맞게 포장을 하여
* 소비자가 받는 형태이다.
 */

fun main() {
    Observable                                  // * 생산자
        .just(0, 1, 2, 3)  // * 생산 연산자
        .map { it * 2 }                         // * 변경 연산자
        .subscribe { println(it) }              // * 소비자


    // * Observable 객체 반환
    val observable = Observable
        .just(0, 1, 2, 3)
        .map { it * 2 }

    // * Disposable 객체 반환
    val disposable = Observable
        .just(0, 1, 2, 3)
        .map { it * 2 }
        .subscribe()
}
