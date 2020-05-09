import io.reactivex.subjects.ReplaySubject

fun main() {

    /*
     * replay subject는 subscribe할 때에 모든 데이터들에 대해서 실행한다.
     */
    val replaySubject = ReplaySubject.create<Int>()

    replaySubject.subscribe { println("A : $it") }
    replaySubject.onNext(1)
    replaySubject.onNext(2)
    replaySubject.onNext(3)

    println("--------------------")
    replaySubject.subscribe { println("B : $it") }

    println("--------------------")
    replaySubject.subscribe { println("C : $it") }


}