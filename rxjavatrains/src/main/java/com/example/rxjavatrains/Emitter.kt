package com.example.rxjavatrains

/**
 * launcher
 */
interface Emitter<T> {

    fun onNext(value: T)

    fun onError(error: Throwable)

    fun onCompleted()
}