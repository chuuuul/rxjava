import io.reactivex.Observable

fun main() {
    Observable.create<String>
    { emitter ->
        emitter.onNext("Hello")
        Thread.sleep(1000)
        emitter.onNext("World")

        // * 바꿔가면서 실습
        val isError = true

        if (isError)
            emitter.onError(Throwable())
        else
            emitter.onComplete()

    }.subscribe({ println(it) }, { println("Error") }, { println("Complete!") })

    Thread.sleep(3000)
}