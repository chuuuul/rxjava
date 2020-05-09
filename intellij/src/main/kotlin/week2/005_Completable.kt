import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable

/*
 * 데이터가 0개 일 때 사용한다.
 * 처음에는 데이터가 0개라는게 이해가 안됐는데,
 * HTTP통신의 REST API 경우 GET이나 POST가 아닌
 * PUT, DELETE의 경우 데이터 응답이 0개 일 때가 있다.
 * 그런 경우 사용하는것이 Completable이다.
 */
fun main() {

    Completable.complete().subscribe(

        object : CompletableObserver {
            override fun onComplete() {
                println("Completable - on Complete")
            }

            override fun onSubscribe(d: Disposable) {
                println("Completable - on Subscribe")
            }

            override fun onError(e: Throwable) {
                println("Completable - on Error")
            }
        }
    )

    // * Consumer
    /*
    Completable.complete().subscribe(
        { println("Consumer Completable - Complete") },
        { println("Consumer Completable - Error") }
    )
    */
}