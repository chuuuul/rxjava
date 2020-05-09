// ! Observer Pattern의 이해

/* *
*  c++ 의 typedef처럼 타입을 정의
*  Observer<T>는 함수를 alias 한 것인데
*  그 함수는 T 형식을 파라미터로 갖고 있고 Unit을 반환하는 함수이다.
*  즉 Observer<T> 자체에 함수를 담는 용도이다.
* */
typealias Observer<T> = (event: T) -> Unit


class EventSource<T> {
    private val observers = mutableListOf<Observer<T>>()

    fun addObserver(observer: Observer<T>) {
        // * observers += observer
        observers.add(observer)
    }


    fun notify(event: T) {
        observers.forEach {
            // * invoke 되어 Observer의 event가 호출됨.
            // ? invoke는 opertor fun invoke() { ... } 로 작성 해야 되는데
            // ? 정의한 적이 없는데 어떻게 Invoke로 동작하는지?
            it(event)
            // * = it.invoke(event)
        }
    }
}

// 변수를 갖지 않는 옵저버
typealias Observer2 = () -> Unit

class EventSource2() {
    private val observers = mutableListOf<Observer2>()

    fun addObserver(observer: Observer2) {
        observers.add(observer)
    }

    fun notify2() {
        observers.forEach {
            it()
        }
    }
}


fun main() {
    // * Case : 1
    val eventSource = EventSource<String>()
    eventSource.addObserver { println("첫번째 옵저버 $it") }
    eventSource.addObserver { println("두번째 옵저버 $it") }

    eventSource.notify("Hi")
    eventSource.notify("Observer Pattern")


    // * Case : 2
    val eventSource2 = EventSource2()
    eventSource2.addObserver { println("변수를 갖지 않는 옵저버 ") }

    eventSource2.notify2()
}