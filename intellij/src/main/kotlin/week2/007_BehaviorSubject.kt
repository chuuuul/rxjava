import io.reactivex.subjects.BehaviorSubject

fun main() {
    /*
     * Behavior Subject는 subscribe하는 순간
     * 바로 직전의 데이터를 받아서 subscribe를 돌린다.
     */
    val behaviorSubject = BehaviorSubject.create<Int>()

    behaviorSubject.subscribe { println("A : $it") }
    behaviorSubject.onNext(1)
    behaviorSubject.subscribe { println("B : $it") }
    println("---------------------")
    behaviorSubject.onNext(2)
    behaviorSubject.onNext(3)

    behaviorSubject.subscribe { println("C : $it") }
    println("---------------------")

    behaviorSubject.onNext(4)
    behaviorSubject.onNext(5)
    behaviorSubject.onNext(6)


}