import io.reactivex.Observable

// * Defer : Observable을 subcribe하기 전까지 Observable을 만들어두지 않고
// * 바로 생성한다.
fun main() {
    val observable = Observable.defer {
        Observable.create<String> {
            println("생산")
            it.onNext("1")
        }
    }

    observable.subscribe { println(it) }
    observable.subscribe { println(it) }


}