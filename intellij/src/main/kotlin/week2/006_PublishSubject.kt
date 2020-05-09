import io.reactivex.subjects.PublishSubject

fun main() {

    /*
     ? Subject는 Observer와 Observable의 성격을 모두 갖고 있는 클래스이다.
     ? 즉, 데이터를 전달하는쪽과 구독하는쪽을 분리한 방식이다.
     * Subject는 기본적으로 메서드가 add되는 형식으로 구독된 메서드들이 계속 쌓이게 된다.
     * PublishSubject는 구독한 시점의 데이터를 새롭게 받아오는 Subject이다.
     */
    val publishSubject = PublishSubject.create<String>()

    publishSubject.subscribe { println("A : $it") }

    publishSubject.onNext("1")
    publishSubject.onNext("2")

    publishSubject.subscribe { println("B : $it") }

    publishSubject.onNext("3")
    publishSubject.onNext("4")


}