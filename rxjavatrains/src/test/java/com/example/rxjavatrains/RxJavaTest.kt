package com.example.rxjavatrains

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.junit.Test

class RxJavaTest {

    @Test
    fun customRxJava() {
        val observable = object : com.example.rxjavatrains.Observable<String>() {
            override fun subscribe(observer: Emitter<String>) {

                for (i in 1..10) {
                    observer.onNext("发射${i}次")
                }

                observer.onCompleted()
            }
        }

        val observer = object : Observer<String>() {
            override fun onSubscribe(emitter: Emitter<String>) {
                println("observer:onSubscribe")
            }

            override fun onNext(t: String) {
                println(t)
            }

            override fun onError(e: Throwable) {
                println("observer:onError")
            }

            override fun onComplete() {
                println("observer:onComplete")
            }

        }

        observable.subscribe(observer)
    }

    @Test
    fun actualRxjava() {

        val list = listOf("1", "2", "3", "4")

        Observable
            .create<List<String>> { emitter ->
                for (s in list) {
                    emitter.onNext(list)
                }
            }
            .map { t -> t.last() }
            .subscribe(object : io.reactivex.Observer<String> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: String) {
                    println(t)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
    }
}

