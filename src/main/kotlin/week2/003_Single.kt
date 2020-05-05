import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import jdk.nashorn.internal.runtime.Context

fun main() {
    /*
    * Single은 데이터가 한개만 전달 될 때 사용한다.
    * 한개이기 때문에 on Next가 없는 모습이다.
    * 대신 on Success에서 처리를 한다.
    */
    Single
        .just("Only One Item")
//        .map { throw Throwable() }
        .subscribe(
            object : SingleObserver<String> {
                override fun onSubscribe(d: Disposable) {
                    println("Single - On Subscribe")
                }

                override fun onSuccess(t: String) {
                    println("Single - On Success : $t")
                }

                override fun onError(e: Throwable) {
                    println("Single - On Error")
                }
            }
        )

    // * Single의 Consumer의 경우 on Subscribe가 없는 모습을 볼 수 있다.

    // * Consumer
    /*
    Single
        .just("Only One Item")
//        .map { throw Throwable() }
        .subscribe(
            {
                println("Single - On Success : $it")
            },
            {
                println("Single - On Error")
            }
        )

     */
}
