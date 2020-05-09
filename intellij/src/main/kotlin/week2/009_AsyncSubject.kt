import io.reactivex.subjects.AsyncSubject

fun main() {
    /*
     * Async Subject는 onComplete가 나타날 때
     * 마지막 데이터만 가져간다.
     */
    val asyncSubject = AsyncSubject.create<String>()


    asyncSubject.subscribe { println("A : $it") }
    asyncSubject.subscribe { println("B : $it") }

    asyncSubject.onNext("hi")
    asyncSubject.onNext("hello")

    asyncSubject.onComplete()

    println("--------------")

    // ? onComplete 한 뒤에 on Next로 새로운 데이터를 보내도 새로운 데이터를 받지 않는다..
    // ? 그리고 이전에 subscribe 되었던 코드들이 사라졌다.

    asyncSubject.onNext("hi")
    asyncSubject.subscribe { println("B : $it") }

    asyncSubject.onComplete()

}