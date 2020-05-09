import io.reactivex.Observable

fun main() {


    Observable.just("first", "second")
//        .map { throw Throwable("error") }
        .subscribe(
            { println("Consumer - On Next : $it") },
            { println("Consumer - On Error") },
            { println("Consumer - On Complete") },
            { println("Consumer - On Subscribe") }
        )

    // * 위의 코드와 아래코드는 동일한데
    // * 람다식으로 변환하고 SAM을 적용해서 위의 코드로 변환 가능하다.

    // * Consumer
    /*
    Observable.just("first", "second")
        .subscribe(
            object : Consumer<String> {
                override fun accept(t: String?) {
                    println("Consumer - On Next : $t")
                }
            },
            object : Consumer<Throwable>
            {
                override fun accept(t: Throwable?) {
                    println("Consumer - On Error")
                }
            },
            object : Action
            {
                override fun run() {
                    println("Consumer - On Complete")
                }
            },
            object  : Consumer<Disposable> {
                override fun accept(t: Disposable?) {
                    println("Consumer - On Disposable")
                }
            }
        )

     */

}