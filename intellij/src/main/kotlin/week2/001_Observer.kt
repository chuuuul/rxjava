import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
    Observable
        .just("first", "second")
        .map { "$it map" }
//        .map { throw Throwable() }
        .subscribe(
            object : Observer<String> {
                override fun onComplete() {
                    println("Complete!")
                }

                override fun onSubscribe(d: Disposable) {
                    println("Subscribe!")
                }

                override fun onNext(t: String) {
                    println("Next : $t")
                }

                override fun onError(e: Throwable) {
                    println("Error")
                }
            }
        )
}