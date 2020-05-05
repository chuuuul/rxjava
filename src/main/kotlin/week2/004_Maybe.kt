import io.reactivex.Maybe
import io.reactivex.MaybeObserver
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

fun main() {
    /*
    * Maybe는 데이터가 0개거나 1개 일 경우 사용한다.
    * Single과 마찬가지로 on Next가 없는 모습이지만
    * On Complete와 On Success가 함께 있다.
    *
    ! empty<String>()으로 데이터를 넣으면 None 값이 들어가게 되는데
    ! 그경우 on Complete가 실행되는걸 확인할 수 있다
    *
    ? 반대로 just("")로 데이터를 전달하게 되면
    ? on Complete가 아닌 on Success가 실행 되는걸 확인 할 수 있다.
    */

    Maybe
        .just("this is maybe data")
//        .empty<String>()
//        .map { throw Throwable() }
        .subscribe (
            object : MaybeObserver<String> {

                override fun onSubscribe(d: Disposable) {
                    println("Maybe - on Subscribe")
                }

                override fun onComplete() {
                    println("Maybe - on Complete")
                }

                override fun onSuccess(t: String) {
                    println("Maybe - on Success : $t")
                }

                override fun onError(e: Throwable) {
                    println("Maybe - on Error")
                }
            }
        )
    // * Consumer
    Maybe
        .just("This is Maybe Data")
        .subscribe(

            { println("Maybe Consumer - on Success : $it") },
            { println("Maybe Consumer - on Error") },
            { println("Maybe Consumer - on Complete") }

        )

}