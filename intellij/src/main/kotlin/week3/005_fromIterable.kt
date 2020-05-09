package week3

import io.reactivex.Observable

fun main() {

    val items = arrayListOf("hi", "Hello", "Aloha")

    Observable.fromIterable(items).subscribe { println(it) }

}