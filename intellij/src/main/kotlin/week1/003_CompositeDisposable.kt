import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

fun main() {
    val compositeDisposable = CompositeDisposable()

    val disposable1 = Observable.just(1, 2).subscribe { println(it) }
    compositeDisposable.add(disposable1)

    // * dispose()와 clear()의 차이 !

    // * 재사용이 불가능하다.
    compositeDisposable.dispose()

    // * 재사용이 가능하다.
//    compositeDisposable.clear()

    val disposable2 = Observable.just(3, 4).delay(1, TimeUnit.SECONDS).subscribe { println(it) }
    compositeDisposable.add(disposable2)

    Thread.sleep(2000L)


}